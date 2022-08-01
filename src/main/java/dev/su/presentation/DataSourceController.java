package dev.su.presentation;

import dev.su.application.datatransfer.ObjectDefinitionDto;
import dev.su.application.datatransfer.ObjectDefinitionTransformer;
import dev.su.domain.datasource.SourceObjectName;
import dev.su.domain.datasource.SourceObjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataSourceController {

    private final ObjectDefinitionTransformer objectDefinitionTransformer;
    private final SourceObjectRepository sourceObjectRepository;

    @PostMapping("/objectDefinitions")
    public ResponseEntity<ObjectDefinitionDto> createObjectDefinition(
            @RequestBody ObjectDefinitionDto objectDefinition
    ) {
        log.info("Creating new source object definition {}", objectDefinition);

        // TODO: Raise exceptions if already exists
        // TODO: Catch user errors, e.g. field type enum mismatch
        sourceObjectRepository.saveObjectDefinition(
                objectDefinitionTransformer.fromDto(objectDefinition)
        );

        return ResponseEntity.ok(objectDefinition);
    }

    @GetMapping("/objectDefinitions/{objectDefinitionName}")
    public ResponseEntity<ObjectDefinitionDto> getObjectDefinition(
            @PathVariable String objectDefinitionName
    ) {
        log.info("Fetching source object definition by name {}", objectDefinitionName);

        // TODO: Raise 404 if doesn't exist
        return ResponseEntity.ok(
                objectDefinitionTransformer.toDto(
                        sourceObjectRepository.getSourceObjectDefinitionByName(
                                SourceObjectName.of(objectDefinitionName)
                        )
                )
        );

    }
}

package dev.su.application.datatransfer;

import dev.su.domain.datasource.SourceObjectDefinition;
import dev.su.domain.datasource.SourceObjectField;
import dev.su.domain.datasource.SourceObjectFieldName;
import dev.su.domain.datasource.SourceObjectName;

import java.util.stream.Collectors;

public class ObjectDefinitionTransformer {

    public SourceObjectDefinition fromDto(ObjectDefinitionDto objectDefinitionDto) {
        SourceObjectDefinition objectDefinition = SourceObjectDefinition.of(
                SourceObjectName.of(objectDefinitionDto.getName()),
                objectDefinitionDto.getFields()
                        .stream()
                        .map(field -> SourceObjectField.of(
                                SourceObjectFieldName.of(field.getName()),
                                SourceObjectField.SourceObjectFieldType.valueOf(field.getType())
                        ))
                        .collect(Collectors.toList())
        );
        objectDefinition.setIdFields(
                objectDefinitionDto.getIdFields()
                        .stream()
                        .map(SourceObjectFieldName::of)
                        .collect(Collectors.toList())
        );
        return objectDefinition;
    }

    public ObjectDefinitionDto toDto(SourceObjectDefinition objectDefinition) {
        return new ObjectDefinitionDto(
                objectDefinition.getName().getValue(),
                objectDefinition.getFields()
                        .stream()
                        .map(field -> new ObjectDefinitionDto.ObjectFieldDefinitionDto(
                                field.getName().getValue(), field.getType().name()
                        ))
                        .collect(Collectors.toList()),
                objectDefinition.getIdFields().stream().map(SourceObjectFieldName::getValue)
                        .collect(Collectors.toList())
        );
    }

}

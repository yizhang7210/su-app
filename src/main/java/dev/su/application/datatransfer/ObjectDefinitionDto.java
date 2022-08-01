package dev.su.application.datatransfer;

import lombok.Value;

import java.util.List;

@Value
public class ObjectDefinitionDto {
    String name;
    List<ObjectFieldDefinitionDto> fields;
    List<String> idFields;

    @Value
    public static class ObjectFieldDefinitionDto {
        String name;
        String type;
    }
}

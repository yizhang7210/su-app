package dev.su.configurations;

import dev.su.application.datatransfer.ObjectDefinitionTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ObjectDefinitionTransformer objectDefinitionTransformer() {
        return new ObjectDefinitionTransformer();
    }
}

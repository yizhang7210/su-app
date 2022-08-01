package dev.su.configurations;

import dev.su.domain.dataflow.InMemoryObjectInstanceRepository;
import dev.su.domain.dataflow.ObjectInstanceRepository;
import dev.su.domain.datasource.InMemorySourceObjectRepository;
import dev.su.domain.datasource.SourceObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DataSourceConfiguration {

    @Bean
    public SourceObjectRepository inMemorySourceObjectRepository() {
        log.info("Injecting in InMemorySourceObjectRepository()");
        return new InMemorySourceObjectRepository();
    }

    @Bean
    public ObjectInstanceRepository inMemoryObjectInstanceRepository() {
        log.info("Injecting in InMemoryObjectInstanceRepository()");
        return new InMemoryObjectInstanceRepository();
    }
}

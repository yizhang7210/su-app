package dev.su.configurations;

import dev.su.domain.compute.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class FeatureConfiguration {

    @Bean
    public FeatureRepository inMemoryFeatureRepository() {
        log.info("Injecting in InMemoryFeatureRepository()");
        return new InMemoryFeatureRepository();
    }

    @Bean
    public FeatureCalculator asyncFeatureCalculator() {
        log.info("Injecting in AsyncFeatureCalculator()");
        return new AsyncFeatureCalculator();
    }

    @Bean
    public FeatureResultRepository inMemoryFeatureResultRepository() {
        log.info("Injecting in InMemoryFeatureResultRepository()");
        return new InMemoryFeatureResultRepository();
    }

}

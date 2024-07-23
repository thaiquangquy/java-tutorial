package org.example.configuration;

import org.example.dependency_injection.MyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    MyRepository myRepository() {
        return new MyRepository();
    }
}

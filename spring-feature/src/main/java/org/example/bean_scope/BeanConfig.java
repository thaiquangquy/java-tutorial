package org.example.bean_scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {
    @Bean
    @SessionScope
    MyBean myBean(){
        return new MyBean();
    }
}

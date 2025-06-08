package org.example.spring_beans.async;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

//    @Bean
//    public ApplicationRunner runner(SpringAsyncIssue springAsyncIssue, SpringAsyncFixed springAsyncFixed, SpringAsyncSelfInjected springAsyncSelfInjected) {
//        return args -> {
//            springAsyncIssue.launch();
//            springAsyncFixed.launch();
//            springAsyncSelfInjected.launch();
//        };
//    }
}

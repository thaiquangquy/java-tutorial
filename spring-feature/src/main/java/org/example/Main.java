package org.example;

import jakarta.annotation.PostConstruct;
import org.example.dependency_injection.DependencyInjectionExample;
import org.example.dependency_injection.MyRepository;
import org.example.dependency_injection.MyService4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private final MyService4 myService4;

    @Autowired
    public Main(MyService4 myService4) {
        this.myService4 = myService4;
    }

    @PostConstruct
    public void runAfterInitialization() {
        MyRepository newRepo = new MyRepository();
        DependencyInjectionExample.MyConstructorDIService constructorDIService = new DependencyInjectionExample.MyConstructorDIService(newRepo);
        constructorDIService.print();

        DependencyInjectionExample.MySetterDIService setterDIService = new DependencyInjectionExample.MySetterDIService();
        setterDIService.setMyRepository(newRepo);
        setterDIService.print();

        DependencyInjectionExample.MySetterDIAutowiredService setterDIAutowiredService = new DependencyInjectionExample.MySetterDIAutowiredService();
//        setterDIAutowiredService.setMyRepository(newRepo);
        setterDIAutowiredService.print(); // Should throw error since repo is not set

        // Assuming DependencyInjectionExample.MyService3 is properly configured for Spring DI
//        myDIService3.print();

        myService4.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
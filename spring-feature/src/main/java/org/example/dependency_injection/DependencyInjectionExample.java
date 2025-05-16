package org.example.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class DependencyInjectionExample {
    // Dependency Injection (DI) is a design pattern used to implement Inversion of Control (IoC),
    // allowing the creation of dependent objects to be handled outside the class that depends on them.
    // In simpler terms, it means that objects are given their dependencies instead of creating them themselves,
    // promoting loose coupling and enhancing testability and maintainability.

    // How Dependency Injection Works
    // Constructor Injection: Dependencies are provided through a class constructor. This is the most common method.
    public static class MyConstructorDIService {
        private final MyRepository myRepository;

        public MyConstructorDIService(MyRepository myRepository) {
            this.myRepository = myRepository;
        }

        // Business methods
        public void print() {
            myRepository.print();
        }
    }

    // Setter Injection: Dependencies are provided through setter methods.
    public static class MySetterDIService {
        private MyRepository myRepository;

        public void setMyRepository(MyRepository myRepository) {
            this.myRepository = myRepository;
        }

        // Business methods
        public void print() {
            if (myRepository != null) {
                myRepository.print();
            } else {
                System.out.println("Oops! There is an error!");
            }
        }
    }

    @Component
    public static class MySetterDIAutowiredService {
        private MyRepository myRepository;

        @Autowired
        public void setMyRepository(MyRepository myRepository) {
            this.myRepository = myRepository;
        }

        public void print() {
            if (myRepository != null) {
                myRepository.print();
            } else {
                System.out.println("Oops! There is an error!");
            }
        }
    }

    // Field Injection: Dependencies are provided directly into fields, typically using annotations.
    @Component
    public static class MyFieldDIService {
        private final MyRepository myRepository;

        @Autowired
        public MyFieldDIService(MyRepository myRepository) {
            this.myRepository = myRepository;
        }

        public void print() {
            myRepository.print();
        }
    }
}

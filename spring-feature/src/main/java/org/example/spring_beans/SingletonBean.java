package org.example.spring_beans;

import org.springframework.context.annotation.Scope;

public class SingletonBean {
    SingletonBean() {
        System.out.println("Singleton bean constructor");
    }
}

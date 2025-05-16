package org.example.spring_beans;

public class RequestBean {
    private String name = "Request Scope";

    RequestBean() {
        System.out.println("Request Bean constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

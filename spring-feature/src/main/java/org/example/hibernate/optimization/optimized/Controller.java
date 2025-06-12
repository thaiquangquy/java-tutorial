package org.example.hibernate.optimization.optimized;

@org.springframework.stereotype.Controller
public class Controller {
    private HibernateLongRunning service;

    int processRequest() {
        var result = service.getCalculated();
        System.out.println("Processed");
        return result;
    }
}

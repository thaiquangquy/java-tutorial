package org.example.hibernate.finalSolution;

class Controller {
    private HibernateLongRunning service;

    int processRequest() {
        var result = service.getCalculated();
        System.out.println("Processed");
        return result;
    }
}



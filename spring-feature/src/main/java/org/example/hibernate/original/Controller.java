package org.example.hibernate.original;

import org.springframework.stereotype.Component;

@org.springframework.stereotype.Controller
class Controller {
    private HibernateLongRunning service;

    int processRequest() {
        var result = service.getCalculated();
        System.out.println("Processed");
        return result;
    }

    // this function take long time to process, output when calling this function is listed below
    //12:00:00: Calculating
    //12:00:03: Retrieved
    //12:00:06: Calculated
    //12:00:09: Processed
    // Q: Provide plan to improve processing time
    // A:
    // 1. Create index for getData function's query -> improve Retrieved data time
    // 2. Use parallel to calculate data in calculate function -> improve calculate data time
    // -> issue when create thread to process this: org.hibernate.LazyInitializationException
    // because the fetch type of Hibernate is Lazy by default -> change FetchType to Eager to initialize data
    // 3. How to reduce the calculate time to processed?
}


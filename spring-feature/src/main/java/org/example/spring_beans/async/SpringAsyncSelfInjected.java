package org.example.spring_beans.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
//
//@Component
//public class SpringAsyncSelfInjected {
//    @Autowired
//    private SpringAsyncSelfInjected springAsyncSelfInjected;
//
//    public void launch() {
//        System.out.println("Launching");
//        springAsyncSelfInjected.doJobAsync();
//        System.out.println("Launched");
//
//        // output will be
//        // Launching
//        // Launched
//        // doing job
//        // Because Async function is calling with a difference bean with same type of SpringAsyncSelfFix, so it trigger the Spring proxy that handle Async
//    }
//
//    @Async
//    public void doJobAsync() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("doing job");
//    }
//}
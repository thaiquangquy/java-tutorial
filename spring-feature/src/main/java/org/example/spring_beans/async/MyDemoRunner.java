package org.example.spring_beans.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyDemoRunner implements ApplicationRunner {
    private final SpringAsyncIssue springAsyncIssue;
    private final SpringAsyncFixed springAsyncFixed;
//    private final SpringAsyncSelfInjected springAsyncSelfInjected;

    MyDemoRunner(SpringAsyncIssue springAsyncIssue,
                 SpringAsyncFixed springAsyncFixed
//                 SpringAsyncSelfInjected springAsyncSelfInjected
    ) {
        this.springAsyncIssue = springAsyncIssue;
        this.springAsyncFixed = springAsyncFixed;
//        this.springAsyncSelfInjected = springAsyncSelfInjected;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyDemoRunner");
        springAsyncIssue.launch();
        springAsyncFixed.launch();
//        springAsyncSelfInjected.launch();
    }
}

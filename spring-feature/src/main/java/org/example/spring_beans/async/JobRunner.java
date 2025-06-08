package org.example.spring_beans.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// a fix to make this work as expected with Async keyword
@Component
public class JobRunner {
    @Async
    public void doJobAsync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doing job");
    }
}

package org.example.spring_beans.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SpringAsyncIssue {
    public void launch() {
        System.out.println("Launching");
        doJobAsync();
        System.out.println("Launched");

        // output will always be
        // Launching
        // doing job
        // Launched
        // Because Async function is calling within its bean, so it bypass the Spring proxy that handle Async
    }

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
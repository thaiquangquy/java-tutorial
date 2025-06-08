package org.example.spring_beans.async;

import org.springframework.stereotype.Component;

@Component
public class SpringAsyncFixed {
    private final JobRunner jobRunner;

    public SpringAsyncFixed(JobRunner jobRunner) {
        this.jobRunner = jobRunner;
    }

    public void launch() {
        System.out.println("Launching");
        jobRunner.doJobAsync(); // this goes through proxy
        System.out.println("Launched");

        // output will be
        // Launching
        // Launched
        // doing job
        // This follow the Spring proxy call from another bean
    }
}
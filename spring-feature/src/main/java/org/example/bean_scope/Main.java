package org.example.bean_scope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final BeanComponent beanComponent;
    
    public Main(BeanComponent beanComponent) {
        this.beanComponent = beanComponent;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is inside command line runner");
        beanComponent.print();
    }
}

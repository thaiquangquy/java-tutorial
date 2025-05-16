package org.example.spring_beans;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final Customer customer;

    @RequestMapping("/nameRS")
    public String helloRS() {
        return customer.getRequestBean().getName();
    }

    @RequestMapping("/nameSSUpdated")
    public String helloSSUpdated() {
        customer.getSessionBean().setName("Session Scope Updated");
        return customer.getSessionBean().getName();
    }

    @RequestMapping("/nameSS")
    public String helloSS() {
        return customer.getSessionBean().getName();
    }
}

package org.example.spring_beans;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private final SessionBean sessionBean;
    private final RequestBean requestBean;

    public Customer(SessionBean sessionBean, RequestBean requestBean) {
        this.sessionBean = sessionBean;
        this.requestBean = requestBean;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public RequestBean getRequestBean() {
        return requestBean;
    }
}

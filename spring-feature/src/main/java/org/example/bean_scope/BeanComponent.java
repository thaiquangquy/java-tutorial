package org.example.bean_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanComponent {
    private final MyBean myBean;
    
    @Autowired
    public BeanComponent(MyBean myBean) {
        this.myBean = myBean;
    }
    
    public void print() {
        System.out.println("MyBean object: " + myBean);
        myBean.print();
    }
}

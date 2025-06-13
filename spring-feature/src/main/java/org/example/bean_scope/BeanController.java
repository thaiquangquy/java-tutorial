package org.example.bean_scope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beans")
public class BeanController {
    private final MyBean myBean;
    private final BeanComponent beanComponent;
    
    public BeanController(MyBean myBean, BeanComponent beanComponent) {
        this.myBean = myBean;
        this.beanComponent = beanComponent;
    }
    
    @GetMapping("/{name}")
    public String print(@PathVariable("name") String name) {
        myBean.print();
        beanComponent.print();
        return name;
    }
}

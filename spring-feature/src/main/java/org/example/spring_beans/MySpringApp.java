package org.example.spring_beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        // Singleton Bean
        singletonBeanTest(context);

        // Prototype Bean
        prototypeBeanTest(context);

        // Session Bean
//        sessionBeanTest(context); // Error due to no session or request in standalone application

        // cleanup
        context.close();
    }

    private static void singletonBeanTest(AnnotationConfigApplicationContext context) {
        SingletonBean singletonBean = context.getBean(SingletonBean.class);
        System.out.println(singletonBean.hashCode());

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1.hashCode());
    }

    private static void prototypeBeanTest(AnnotationConfigApplicationContext context) {
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean.hashCode());

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.hashCode());
    }

    private static void sessionBeanTest(AnnotationConfigApplicationContext context) {
        SessionBean sessionBean = context.getBean(SessionBean.class);
        System.out.println(sessionBean.hashCode());

        SessionBean sessionBean1 = context.getBean(SessionBean.class);
        System.out.println(sessionBean1.hashCode());
    }
}

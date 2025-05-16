package org.example.annotaions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationParsing {
    public static void main(String[] args) throws ClassNotFoundException {
        for (Method method : AnnotationParsing.class.getClassLoader()
                .loadClass("org.example.annotaions.AnnotationExample")
                .getMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                try {
                    for (Annotation anno: method.getDeclaredAnnotations()) {
                        System.out.println("Annotation in Method '" + method + "' : " + anno);
                    }
                    MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                    if (methodAnno.revision() == 1) {
                        System.out.println("Method with revision no 1 = " + method);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    private List versions;

    @SuppressWarnings("unchecked")
    public void addVersion(String version) {
        versions.add(version);
    }
}

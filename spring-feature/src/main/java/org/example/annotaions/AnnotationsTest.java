package org.example.annotaions;

import java.io.FileNotFoundException;

public class AnnotationsTest {
    public static void main(String[] args) {
        IAnnotationExample anotationExample = new AnnotationExample();
        System.out.println(anotationExample.toString());
        AnnotationExample.oldMethod();
        try {
            AnnotationExample.genericsTest();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        IAnnotationExample child = new ChildAnnotationExample();
        System.out.println(child.toString());
    }
}

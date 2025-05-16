package org.example.annotaions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample implements IAnnotationExample {
    @Override
    @MethodInfo(author = "Quy", date = "May 2025", comments = "Main method", revision = 1)
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MethodInfo(date = "May 2025", comments = "deprecated method")
    public static void oldMethod() {
        System.out.println("old method, don't use it");
    }

    @SuppressWarnings({"unchecked", "rawtypes", "deprecated"})
    @MethodInfo(author = "Quy", revision = 10, comments = "Main method", date = "May 2025")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}

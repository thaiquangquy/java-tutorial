package design_patterns;

public class OuterClass {
    // static string
    private static String msg = "Hello world";
    private String anotherMsg = "Hi";

    // static nested class
    public static class NestedStaticClass {
        public void printMessage() {
            // able to access static member of Outer class
            System.out.println("Message from nested static class: " + msg);

            // compile fail since anotherMsg is non-static
//            System.out.println("Message from nested static class: " + anotherMsg);
        }
    }

    public class InnerClass {
        public void display() {
            System.out.println("Message from inner class: " + msg);
            System.out.println("Another message from inner class: " + anotherMsg);
        }
    }
}

class StaticClassMain {
    public static void main(String[] args) {
        // Create instance of static nested class without outer class
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printMessage();

        // need an outer class instance to create instance of non-static nested class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // combine above step into one
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.display();

    }
}

package design_patterns.singleton;

public class DemoNonThreadSafe {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        // Single thread => OK
//        SingletonNonThreadSafe singleton1 = SingletonNonThreadSafe.getInstance("FOO");
//        SingletonNonThreadSafe singleton2 = SingletonNonThreadSafe.getInstance("BAR");
//        System.out.println(singleton1.value);
//        System.out.println(singleton2.value);

        // Multiple threads => NOT OK
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonNonThreadSafe singleton = SingletonNonThreadSafe.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonNonThreadSafe singleton = SingletonNonThreadSafe.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

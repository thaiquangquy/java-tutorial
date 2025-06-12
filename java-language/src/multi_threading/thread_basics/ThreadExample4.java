package multi_threading.thread_basics;

public class ThreadExample4 {
    // Implement runnable interface with anonymous class
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("My Thread is running");
                System.out.println("My Thread is finished");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}

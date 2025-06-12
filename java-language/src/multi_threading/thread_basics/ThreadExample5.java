package multi_threading.thread_basics;

public class ThreadExample5 {
    // Implement Runnable interface with Lambda expression
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Lambda running");
            System.out.println("Lambda finished");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

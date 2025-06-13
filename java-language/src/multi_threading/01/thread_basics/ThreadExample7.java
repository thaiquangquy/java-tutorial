package multi_threading.thread_basics;

public class ThreadExample7 {
    // Implement Runnable interface with Lambda expression
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };
        Thread thread = new Thread(runnable, "The Thread");
        thread.start();
    }
}

package multi_threading.thread_basics;

public class ThreadExample9Daemon {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true); // daemon thread is low-priority thread that provide service to user thread
        // When all the user thread dies, daemon thread will be terminated automatically
        // Make sure the daemon is not in middle of something when main thread is down is a best practice
        thread.start();
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package multi_threading.thread_basics;

public class ThreadExample10Join {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        // without the join deamon thread will not have a chance to run
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

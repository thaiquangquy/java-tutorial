package multi_threading.c02.virtual_thread;

public class VirtualThreadExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            System.out.println(Thread.currentThread().getName() + " is finished");
        };

        // Create and start virtual thread immediately
        Thread vThread = Thread.ofVirtual().name("Thread 1").start(runnable);

        // Create virtual thread but start later
        Thread vThreadUnstarted = Thread.ofVirtual().name("Thread 2").unstarted(runnable);
        vThreadUnstarted.start();

        try {
            vThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

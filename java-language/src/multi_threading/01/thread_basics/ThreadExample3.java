package multi_threading.thread_basics;

public class ThreadExample3 {
    // Implement Runnable interface
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("My Thread is running");
            System.out.println("My Thread is finished");
        }
    }


    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
    }
}

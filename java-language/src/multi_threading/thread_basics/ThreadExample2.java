package multi_threading.thread_basics;

public class ThreadExample2 {
    // Create subclass of Java Thread class
    public static class MyThread extends Thread {
        public void run() {
            System.out.println("My thread is running");
            System.out.println("My thread is finished");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

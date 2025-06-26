package multi_threading.c10.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        
        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));
        
        executorService.shutdown();
    }
    
    public static Runnable newRunnable(String msg) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + ": " + msg);
        };
    }
    
}

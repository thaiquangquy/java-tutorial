package multi_threading.c10.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSubmitExample {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // Future provide status of task
        Future future = executorService.submit(newRunnable("Task 1"));
        System.out.println(future.isDone());
        
        try {
            future.get();
        } catch (InterruptedException e) {
        
        } catch (ExecutionException e) {
        
        }
        System.out.println(future.isDone());
        
        executorService.shutdown();
    }
    
    private static Runnable newRunnable(String msg) {
//        return () -> {
//            System.out.println(Thread.currentThread().getName() + ": " + msg);
//        };
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + msg);
            }
        };
    }
    
}

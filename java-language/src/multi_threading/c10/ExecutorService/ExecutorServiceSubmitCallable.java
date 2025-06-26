package multi_threading.c10.ExecutorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSubmitCallable {
    
    public static void main(String[] args) {
//        submitCallableTest();
//        invokeAnyTest();
        invokeAllTest();
    }
    
    private static void submitCallableTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        
        // Future provide status of task
        Future future = executorService.submit(newCallable("Task 1"));
        System.out.println(future.isDone());
        
        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException _) {
        
        }
        System.out.println(future.isDone());
        
        executorService.shutdown();
    }
    
    private static void invokeAnyTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));
        
        try {
            // Use-case: Call 3 servers in a row and get the fastest result
            String result = (String) executorService.invokeAny((Collection) callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException _) {
        
        }
        
        executorService.shutdown();
    }
    
    private static void invokeAllTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));
        
        try {
            // Use-case: Call 3 servers in a row and get all the result
            List<Future<String>> results = executorService.invokeAll(callables);
            for (Future future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException _) {
        
        }
        
        executorService.shutdown();
    }
    
    private static Callable newCallable(String msg) {
//        return new Callable() {
//            @Override
//            public Object call() throws Exception {
//                String completeMsg = Thread.currentThread().getName() + ": " + msg;
//                return completeMsg;
//            }
//        };
        return () -> Thread.currentThread().getName() + ": " + msg;
    }
    
}

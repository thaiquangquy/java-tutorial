package multi_threading.c10.ExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceImplementation {
    
    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000;
        
        // Execute the task ASAP
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime, // the time that thread that not in pool thread alive
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(128)
        );
        
        // Execute the task within a fixed time window
        ExecutorService fixedThreadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }
    
}

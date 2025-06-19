package multi_threading.c05.synchronized_keyword;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class SynchronizedLambda {
    
    private static Object object = null;
    
    public static synchronized void setObject(Object o) {
        object = o;
    }
    
    public static void consumeObject(Consumer<Object> consumer) {
        consumer.accept(object);
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> consumeObject((obj) -> {
            synchronized (SynchronizedLambda.class) {
                System.out.println(obj);
            }
        }));
        
        Thread t2 = new Thread(() -> consumeObject((obj) -> {
            synchronized (String.class) {
                System.out.println(obj);
            }
        }));
        t1.start();
        t2.start();
        
        setObject(1);
        consumeObject((obj) -> {
            synchronized (SynchronizedLambda.class) {
                System.out.println(obj);
            }
        });
        
        consumeObject((obj) -> {
            synchronized (String.class) {
                System.out.println(obj);
            }
        });
    }
}

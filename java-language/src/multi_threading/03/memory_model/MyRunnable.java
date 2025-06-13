package multi_threading.memory_model;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable {
    
    private int count = 0;
    private multi_threading.memory_model.MyObject myCtorObject;
    
    public MyRunnable() {
    }
    
    public MyRunnable(multi_threading.memory_model.MyObject myObject) {
        this.myCtorObject = myObject;
    }
    
    public synchronized int getCount() {
        return count;
    }
    
    @Override
    public void run() {
        multi_threading.memory_model.MyObject myObject = new multi_threading.memory_model.MyObject(); // This is a local variable and will not be share between threads
        System.out.println(Thread.currentThread().getName() + " My local object: " + myObject);
        System.out.println(Thread.currentThread().getName() + " My ctor object: " + myCtorObject);
        
        for (int i = 0; i < 1_000_000; i++) {
            // This code will cause Race condition
            // Or write visibility problem
//            this.count++;
            
            // this makes one thread reach the count of 2_000_000 for the runnable
            synchronized (this) {
                this.count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
}

package multi_threading.c09.java_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true); // guarantee fairness, false by default
        
        lock.lock();
        
        // do something
        
        lock.unlock();
    }

}

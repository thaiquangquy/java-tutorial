package multi_threading.c09.java_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    private long count;
    private Lock lock = new ReentrantLock();
    
    public void inc() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }

    public long getCount() {
        try {
            lock.lock();
            return count;
        } finally {
            lock.unlock();
        }
    }
}

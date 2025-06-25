package multi_threading.c09.java_lock;

public class CounterSynchronized {
    private long count = 0;
    
    public synchronized void inc() {
        count++;
    }
    
    public synchronized long getCount() {
        return count;
    }
}

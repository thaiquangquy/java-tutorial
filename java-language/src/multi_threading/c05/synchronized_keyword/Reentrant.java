package multi_threading.c05.synchronized_keyword;

public class Reentrant {
    private int count = 0;
    
    public synchronized void inc() {
        this.count++;
    }
    
    // Since synchronized is reentrant, this won't cause a self-deadlock
    public synchronized int incAndGet() {
        inc();
        return this.count;
    }
}

package multi_threading.c05.synchronized_keyword;

public class SharedMonitorObject {
    private Object monitor = null;
    
    private int counter = 0;
    
    public SharedMonitorObject(Object monitor) {
        if (monitor == null) {
            throw new IllegalArgumentException("Monitor object cannot be null.");
        }
        this.monitor = monitor;
    }
    
    public void incCounter() {
        synchronized (this.monitor) {
            this.counter++;
        }
    }
    
    public int getCounter() {
        synchronized (this.monitor) {
            return counter;
        }
    }
}

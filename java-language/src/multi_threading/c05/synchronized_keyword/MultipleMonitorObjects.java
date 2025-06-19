package multi_threading.c05.synchronized_keyword;

public class MultipleMonitorObjects {
    private Object monitor1 = new Object();
    private Object monitor2 = new Object();
    
    private int counter1 = 0;
    private int counter2 = 0;
    
    public void incCounter1() {
        synchronized (this.monitor1) {
            counter1++;
        }
    }
    
    public void incCounter2() {
        synchronized (this.monitor2) {
            counter2++;
        }
    }
    
    public int getCounter1() {
        synchronized (this.monitor1) {
            return counter1;
        }
    }
    
    public int getCounter2() {
        synchronized (this.monitor2) {
            return counter2;
        }
    }
}

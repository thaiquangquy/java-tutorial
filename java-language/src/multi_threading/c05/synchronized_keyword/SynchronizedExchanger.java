package multi_threading.c05.synchronized_keyword;

public class SynchronizedExchanger {
    protected Object object = null;
    
    public synchronized void setObject(Object o) {
        object = o;
    }
    
    public synchronized Object getObject() {
        return object;
    }
    
    public void setObj(Object o) {
        synchronized (this) {
            object = o;
        }
    }
    
    public Object getObj() {
        synchronized (this) {
            return object;
        }
    }
}

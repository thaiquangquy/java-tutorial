package multi_threading.c05.synchronized_keyword;

public class SynchronizedHappenBefore {
    
    private long count = 0;
    private Object obj = null;
    
    public void set(Object o) {
        
        // 2. count value may not be the latest value from the main memory for the incremental operator
        // Java happen before a guarantee will make sure that the count value will be written to the main memory
        // after synchronized block but the value of count here is not reliable
        this.count++;
        synchronized (this) {
            this.obj = o;
        }
        
        synchronized (this) {
            //1. Since those are executed in synchronized block,
            // we can relay on count and obj value
            this.count++;
            this.obj = o;
        }
        
        //3. count value will have the latest value from the main memory for the incremental operator
        // by Java happen before a guarantee
        // but we don't know exactly when will the new value of count will make sure that the count value will be written to the main memory
        synchronized (this) {
            this.obj = o;
        }
        this.count++;
    }
    
    public Object get() {
        synchronized (this) {
            return this.obj;
        }
    }
}

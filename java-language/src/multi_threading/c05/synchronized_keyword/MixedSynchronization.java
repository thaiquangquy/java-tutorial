package multi_threading.c05.synchronized_keyword;

public class MixedSynchronization {
    public static Object staticObj = null;
    
    public static synchronized void setStaticObj(Object obj) {
        staticObj = obj;
    }
    public static synchronized Object getStaticObj() {
        return staticObj;
    }
    
    public Object instanceObj = null;
    
    public synchronized void setInstanceObj(Object obj) {
        instanceObj = obj;
    }
    
    public synchronized Object getInstanceObj() {
        return instanceObj;
    }
    
}

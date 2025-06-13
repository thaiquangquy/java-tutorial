package multi_threading.memory_model;

public class SeparateObjects {
    
    public static void main(String[] args) {
        int myLocalVar = 0; // this variable will be stored in stack
        String myLocalString = "Text"; // this in another way will be stored in heap since special behavior of String
        // To save memory, literal string will be created in heap and its reference could be share if another thread defines the same string
        
        multi_threading.memory_model.MyObject myShareObject = new multi_threading.memory_model.MyObject();
        Runnable runnable1 = new multi_threading.memory_model.MyRunnable(myShareObject);
        Runnable runnable2 = new multi_threading.memory_model.MyRunnable(myShareObject);
        
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

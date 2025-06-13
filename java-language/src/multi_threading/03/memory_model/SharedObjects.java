package multi_threading.memory_model;

public class SharedObjects {
    
    public static void main(String[] args) {
        int myLocalVar = 0; // this variable will be stored in stack
        String myLocalString = "Text"; // this in another way will be had stored in heap since special behavior of String
        // To save memory, literal string will be created in heap and its reference could be share if another thread defines the same string
        multi_threading.memory_model.MyObject myShareObject = new multi_threading.memory_model.MyObject();
        Runnable runnable = new multi_threading.memory_model.MyRunnable(myShareObject);
        
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final result: " + ((multi_threading.memory_model.MyRunnable) runnable).getCount());
    }
}

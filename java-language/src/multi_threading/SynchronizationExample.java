package multi_threading;

public class SynchronizationExample {

    public static void main(String[] args) {
        shareObjTest();
    }

    private void nonShareObjTest() {
        // Creating an object of class B
        B b = new B();

        // Initializing instance t1 of Thread
        // class with object of class B
        Thread t1 = new Thread(b);

        // Initializing instance t2 of Thread
        // class with object of class B
        Thread t2 = new Thread(b);

        // Initializing thread t1 with name
        //'Thread A'
        t1.setName("Thread A");

        // Initializing thread t2 with name
        //'Thread B'
        t2.setName("Thread B");

        // Starting thread instance t1 and t2
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void shareObjTest() {
        A shared = new A();
        // Creating an object of class B
//        BShare b = new BShare(shared);

        // Initializing instance t1 of Thread
        // class with object of class B
        Thread t1 = new Thread(new BShare(shared));

        // Initializing instance t2 of Thread
        // class with object of class B
        Thread t2 = new Thread(new BShare(shared));

        // Initializing thread t1 with name
        //'Thread A'
        t1.setName("Thread A");

        // Initializing thread t2 with name
        //'Thread B'
        t2.setName("Thread B");

        // Starting thread instance t1 and t2
        t1.start();
        t2.start();
    }
}

// Using Synchronization
class A {
//    synchronized void sum(int n) {
    // with synchronized keyword, one thread will be executed after other
    // result will be like below
//        Thread A : 11
//        Thread A : 12
//        Thread A : 13
//        Thread A : 14
//        Thread A : 15
//        Thread B : 11
//        Thread B : 12
//        Thread B : 13
//        Thread B : 14
//        Thread B : 15

    void sum(int n) {
        // without synchronized, the output will mash up like this
//        Thread A : 11
//        Thread A : 12
//        Thread A : 13
//        Thread A : 14
//        Thread A : 15
//        Thread B : 11
//        Thread B : 12
//        Thread B : 13
//        Thread B : 14
//        Thread B : 15

        // Creating a thread instance
        Thread t = Thread.currentThread();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println(t.getName() + " : " + (n + i));
        }
    }
}

// Class B extending thread class
class B extends Thread {
    // Creating an object of class A
    A a = new A();

    public void run() {

        // Calling sum() method
        a.sum(10);
    }
}

// Class B extending thread class
class BShare extends Thread {
    A a;

    public BShare(A a) {
        this.a = a;
    }

    public void run() {

        // Calling sum() method
        a.sum(10);
    }
}
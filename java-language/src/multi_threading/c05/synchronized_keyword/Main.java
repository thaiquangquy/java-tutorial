package multi_threading.c05.synchronized_keyword;

public class Main {
    
    public static void main(String[] args) {
//        synchronizedExchangerTest();
//        staticSynchronizedExchangerTest();
//        mixedSynchronizedExchangerTest();
//        multipleMonitorObjectsTest();
//        sharedMonitorObjectTest();
        reentrantTest();
    }
    
    private static void synchronizedExchangerTest() {
        SynchronizedExchanger exchanger = new SynchronizedExchanger();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                exchanger.setObject("" + i);
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(exchanger.getObject());
            }
        });
        
        thread1.start();
        thread2.start();
    }
    
    private static void staticSynchronizedExchangerTest() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                StaticSynchronizedExchanger.setObject("" + i);
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(StaticSynchronizedExchanger.getObject());
            }
        });
        
        thread1.start();
        thread2.start();
    }
    
    private static void mixedSynchronizedExchangerTest() {
        MixedSynchronization exchanger = new MixedSynchronization();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                MixedSynchronization.setStaticObj("" + i);
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(exchanger.getInstanceObj());
            }
        });
        
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Static obj: " + MixedSynchronization.getStaticObj());
            }
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    private static void multipleMonitorObjectsTest() {
        MultipleMonitorObjects exchanger = new MultipleMonitorObjects();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                exchanger.incCounter1();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                exchanger.incCounter2();
            }
        });
        
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Counter 1: " + exchanger.getCounter1());
            }
        });
        
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Counter 2: " + exchanger.getCounter2());
            }
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    
    private static void sharedMonitorObjectTest() {
        Object monitor1 = new Object();
        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
        
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                smo1.incCounter();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                smo2.incCounter();
            }
        });
        
        Object monitor2 = new Object();
        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
        Thread thread3 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                smo3.incCounter();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        System.out.println(smo1.getCounter());
        System.out.println(smo2.getCounter());
        System.out.println(smo3.getCounter());
    }
    
    
    private static void reentrantTest() {
        Reentrant reentrant = new Reentrant();
        Thread t1 = new Thread(() -> {
            System.out.println(reentrant.incAndGet());
        });
        t1.start();
    }
}

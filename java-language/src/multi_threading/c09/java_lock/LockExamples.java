package multi_threading.c09.java_lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExamples {
    
    public static void main(String[] args) {
//        lockBasics();
//        lockInterruptibly();
//        lockInterruptiblyFromOther();
//        tryLock();
        
        ReentrantLock reentrantLock = new ReentrantLock();
        int holdCount = reentrantLock.getHoldCount();
        int queueLength = reentrantLock.getQueueLength();
        boolean hasQueuedThisThread = reentrantLock.hasQueuedThread(Thread.currentThread());
        boolean hasQueuedThreads = reentrantLock.hasQueuedThreads();
        boolean isFair = reentrantLock.isFair();
        boolean isLocked = reentrantLock.isLocked();
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
    }
    
    private static void lockBasics() {
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {
            lockSleepUnlock(lock, 1000);
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    private static void lockInterruptibly() {
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
    
    private static void lockInterruptiblyFromOther() {
        Lock lock = new ReentrantLock();
        AtomicInteger sharedResource = new AtomicInteger();
        Thread workerThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " attempting to acquire lock...");
                lock.lockInterruptibly(); // Attempt to acquire lock, allowing interruption
//                lock.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock.");
                
                // Simulate some work in the critical section
                for (int i = 0; i < 5; i++) {
                    sharedResource.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " updated resource: " + sharedResource);
                    Thread.sleep(500); // Simulate work
                }
                
            } catch (InterruptedException e) {
                System.out.println(
                    Thread.currentThread().getName() + " was interrupted while waiting for or holding the lock.");
            } finally {
                if (lock.tryLock()) { // Check if the current thread holds the lock before unlocking
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released lock.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " did not hold the lock to release.");
                }
            }
        }, "WorkerThread");
        
        // Start the worker thread
        workerThread.start();
        
        Thread anotherThread = new Thread(() -> {
            try {
                Thread.sleep(1500);
                System.out.println("Another thread interrupting WorkerThread...");
                workerThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        anotherThread.start();
        
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread-2 trying to acquire lock interruptibly...");
//                lock.lockInterruptibly();  // Can be interrupted while waiting
                lock.lock();  // This will make thread2 wait forever
                try {
                    System.out.println("Thread-2 acquired the lock.");
                } finally {
                    lock.unlock();
                }
//            } catch (InterruptedException e) {
//                System.out.println("Thread-2 was interrupted while waiting for the lock.");
//            }
            } catch (Exception e) {
                System.out.println("Thread-2 was interrupted while waiting for the lock.");
            }
        });
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (
            InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
        
        try {
            workerThread.join();
            anotherThread.join();
            thread2.join();
        } catch (
            InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final shared resource value: " + sharedResource);
    }
    
    private static void tryLock() {
        Lock lock = new ReentrantLock();
        
        Runnable runnable = () -> {
            if (lock.tryLock()) {
                try {
                    // manipulate protected state
                    printThreadMsg(" try lock successfully");
                } finally {
                    lock.unlock();
                }
            } else {
                printThreadMsg(" try lock fail");
            }
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    private static void lockSleepUnlock(Lock lock, int timeInMilies) {
        try {
            lock.lock();
            printThreadMsg(" holds the lock");
            sleep(timeInMilies);
        } finally {
            lock.unlock();
        }
    }
    
    private static void printThreadMsg(String msg) {
        System.out.println(Thread.currentThread().getName() + msg);
    }
    
    private static void sleep(long timeMilis) {
        try {
            Thread.sleep(timeMilis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

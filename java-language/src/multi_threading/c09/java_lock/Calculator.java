package multi_threading.c09.java_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {
    
    public enum CalculationType {
        UNSPECIFIED(-1),
        ADDITION(0),
        SUBTRACTION(1);
        
        private final int value;
        
        CalculationType(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public static class Calculation {
        
        //        public static final int UNSPECIFIED = -1;
//        public static final int ADDITION = 0;
//        public static final int SUBTRACTION = 1;
//        int type = UNSPECIFIED;
        CalculationType type = CalculationType.UNSPECIFIED;
        
        public double value;
        
        public Calculation(CalculationType type, double value) {
            this.type = type;
            this.value = value;
        }
    }
    
    private double result = 0.0D;
    Lock lock = new ReentrantLock();
    
    public void add(double value) {
        try {
            lock.lock();
            result += value;
        } finally {
            lock.unlock();
        }
    }
    
    public void subtract(double value) {
        try {
            lock.lock();
            result -= value;
        } finally {
            lock.unlock();
        }
    }
    
    public void calculate(Calculation... calculations) {
        try {
            lock.lock();
            
            for (Calculation calculation : calculations) {
                switch (calculation.type) {
                    case CalculationType.ADDITION -> add(calculation.value);
                    case CalculationType.SUBTRACTION -> subtract(calculation.value);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

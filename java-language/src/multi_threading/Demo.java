package multi_threading;

public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(Demo::threadFunc);
        TenantContextHolder.setCurrentTenantId(t1.getName(), "011");
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void threadFunc() {
        System.out.println("Thread tenantId: " + TenantContextHolder.getCurrentTenantId(Thread.currentThread().getName()));
        Thread t2 = new Thread(Demo::anotherThreadFunc);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void anotherThreadFunc() {
        System.out.println("Thread tenantId: " + TenantContextHolder.getCurrentTenantId(Thread.currentThread().getName()));
    }
}

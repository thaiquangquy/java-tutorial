package design_patterns.creational.singleton;

public class SingletonNonThreadSafe {
    private static SingletonNonThreadSafe instance;
    public String value;

    private SingletonNonThreadSafe(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonNonThreadSafe getInstance(String value) {
        if (instance == null) {
            instance = new SingletonNonThreadSafe(value);
        }
        return instance;
    }
}

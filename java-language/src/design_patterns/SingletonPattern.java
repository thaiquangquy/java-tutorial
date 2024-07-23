package design_patterns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SingletonPattern {
    // Basic example of implementing
    static class Singleton {
        private static final Singleton singleton = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        SingletonPattern.Singleton instance = SingletonPattern.Singleton.getInstance();
        System.out.println("Singleton instance obtained: " + instance);
    }
}
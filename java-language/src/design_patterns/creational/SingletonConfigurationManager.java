package design_patterns.creational;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Problem

//In Java applications, configuration files are often used to store application-wide settings,
// such as database connection URLs, logging levels, and email server settings.
// However, if multiple instances of a class access the configuration file directly, there is a risk of data corruption and inconsistencies.

//Solution

// The Singleton design pattern can be used to create a single instance of a class that is responsible for loading and managing the configuration file.
// This ensures that all instances of the class have access to the same configuration data, and that the data is not corrupted or overwritten.

// Implementation
public class SingletonConfigurationManager {
    private static SingletonConfigurationManager instance = null;

    private Properties properties;

    private SingletonConfigurationManager() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SingletonConfigurationManager getInstance() {
        if (instance == null) {
            instance = new SingletonConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

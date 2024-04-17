package info.seleniumcucumber.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    private ConfigurationReader() {
        // Private constructor to prevent instantiation
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property " + key + " not found in configuration file");
        }
        return value;
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static int getIntProperty(String key) {
        String value = getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid integer value for property " + key, e);
        }
    }

    public static boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        return Boolean.parseBoolean(value);
    }

    public static long getLongProperty(String key) {
        String value = getProperty(key);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid long value for property " + key, e);
        }
    }

    public static double getDoubleProperty(String key) {
        String value = getProperty(key);
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid double value for property " + key, e);
        }
    }
}
package com.hybridframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TempDataStore {

	private static final String FILE_PATH = "temp-test-data.properties";
    private static final Properties properties = new Properties();

    // Load existing data (if file exists)
    static {
    	File file = new File(FILE_PATH);
        if (file.exists()) {
            try (FileInputStream input = new FileInputStream(file)) {
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load test data store", e);
            }
        }
    }

    // Save a key-value pair
    public static void set(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
            properties.store(output, "Temporary test data");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write test data", e);
        }
    }

    // Retrieve a value
    public static String get(String key) {
        return properties.getProperty(key);
    }

    // Delete the file and clear data
    public static void clear() {
        File file = new File(FILE_PATH);
        if (file.exists()) file.delete();
        properties.clear();
    }
}

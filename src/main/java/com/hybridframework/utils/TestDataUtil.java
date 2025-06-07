package com.hybridframework.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hybridframework.config.ConfigLoader;

public class TestDataUtil {
	
	private static Properties prop = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("testdata.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties file not found in classpath");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

}

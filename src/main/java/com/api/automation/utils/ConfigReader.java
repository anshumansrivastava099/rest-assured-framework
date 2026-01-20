package com.api.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static{

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        }
        catch (Exception e)
        {
            throw  new RuntimeException("Unable to load");
        }
    }

    public static String get(String key)
    {
       return properties.getProperty(key);

    }
}

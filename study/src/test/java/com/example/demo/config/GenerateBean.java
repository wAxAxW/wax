package com.example.demo.config;

import java.util.Properties;

/**
 * @author
 * @date
 */
public class GenerateBean {
    private Properties properties;
    private String db;

    public Properties getProperties() {
        return properties;
    }

    public GenerateBean setProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    public String getDb() {
        return db;
    }

    public GenerateBean setDb(String db) {
        this.db = db;
        return this;
    }

    public String getProperty(String name) {
        return String.valueOf(properties.get(name));
    }
}

package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class GeneratePropertiesBean {
    @Value("#{generatorPropertySourcesPlaceholderConfigurer.getProperty('db.driverName')}")
    private String db;

    @Value("${db.driverName}")
    private String db2;

    public String getDb2() {
        return db2;
    }

    public GeneratePropertiesBean setDb2(String db2) {
        this.db2 = db2;
        return this;
    }

    public String getDb() {
        return db;
    }

    public GeneratePropertiesBean setDb(String db) {
        this.db = db;
        return this;
    }
}

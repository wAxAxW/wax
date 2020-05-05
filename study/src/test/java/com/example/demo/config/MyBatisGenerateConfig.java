package com.example.demo.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @author
 * @date
 */
@Configuration
public class MyBatisGenerateConfig {

    @Bean(value = "generatorPropertySourcesPlaceholderConfigurer")
    public static GenerateBean properties() {
        GenerateBean generateBean = new GenerateBean();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("generator.yml"));
        Properties object = yaml.getObject();
        generateBean.setProperties(object);
        return generateBean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer get() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("generator.yml"));
        Properties object = yaml.getObject();
        propertySourcesPlaceholderConfigurer.setProperties(object);
        return propertySourcesPlaceholderConfigurer;
    }


}

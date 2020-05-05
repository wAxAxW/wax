package com.example.demo.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class MyGlobalConfig extends GlobalConfig {
    @Value("${global.outputDir}")
    @Override
    public GlobalConfig setOutputDir(String outputDir) {
        String projectPath = System.getProperty("user.dir");
        outputDir = projectPath + outputDir;
        return super.setOutputDir(outputDir);
    }

    @Value("${global.open}")
    @Override
    public GlobalConfig setOpen(boolean open) {
        return super.setOpen(open);
    }

    @Value("${global.author}")
    @Override
    public GlobalConfig setAuthor(String author) {
        return super.setAuthor(author);
    }

    @Value("${global.swagger2}")
    @Override
    public GlobalConfig setSwagger2(boolean swagger2) {
        return super.setSwagger2(swagger2);
    }
}

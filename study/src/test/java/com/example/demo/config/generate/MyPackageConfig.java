package com.example.demo.config.generate;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class MyPackageConfig {
    private PackageConfig packageConfig;

    public MyPackageConfig(
            @Value("${package.module}")
                    String moduleName,
            @Value("${package.parent}")
                    String parent) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(parent);
        this.packageConfig = packageConfig;
    }

    public PackageConfig getPackageConfig() {
        return packageConfig;
    }

    public MyPackageConfig setPackageConfig(PackageConfig packageConfig) {
        this.packageConfig = packageConfig;
        return this;
    }
}

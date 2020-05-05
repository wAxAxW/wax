package com.example.demo.config;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class MydataSourceConfig {
    private DataSourceConfig dataSourceConfig;

    public MydataSourceConfig(
            @Value("${db.url}")
                    String url,
            @Value("${db.driverName}")
                    String driverName,
            @Value("${db.userName}")
                    String userName,
            @Value("${db.passWord}")
                    String passWord) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //dataSourceConfig.setDbQuery(new IDbQuery());
        //dataSourceConfig.setDbType(new DbType());
        //dataSourceConfig.setSchemaName("");
        //dataSourceConfig.setTypeConvert(new ITypeConvert());
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(userName);
        dataSourceConfig.setPassword(passWord);
        this.dataSourceConfig = dataSourceConfig;
    }

    public DataSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public MydataSourceConfig setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
        return this;
    }
}

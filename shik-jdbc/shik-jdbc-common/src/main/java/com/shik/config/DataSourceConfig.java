package com.shik.config;

import com.google.common.collect.Maps;
import com.shik.support.component.DynamicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2016/11/28
 */
@Configuration
public class DataSourceConfig {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>primary datasource init..............");
        return DataSourceBuilder.create().build();
    }

    /**
     * 只读库  生产环境可以使用dns在多个读库中负载均衡
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "datasource.read")
    public DataSource readDataSource() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>read datasource init.............");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource")
    public DynamicDataSource dataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("readDataSource") DataSource readDataSource) {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(primaryDataSource);
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put("primaryDataSource", primaryDataSource);
        targetDataSources.put("readDataSource", readDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

}

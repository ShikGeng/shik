package com.shik.config;

import com.google.common.collect.Maps;
import com.shik.support.component.DynamicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author gengshikun
 * @date 2016/11/28
 */
@Configuration
//@ImportResource("classpath:spring/application-data.xml")
@ConfigurationProperties(prefix = "datasource")
@PropertySource("classpath:config/jdbc.properties")
public class DataSourceConfig {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "primaryDataSource")
    @org.springframework.context.annotation.Primary
    public DataSource primaryDataSource() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>primary datasource init..............");
//        DataSource ds = DataSourceBuilder.create().build();
        DriverManagerDataSource dd = new DriverManagerDataSource();
        dd.setDriverClassName(primary.getDriver());
        dd.setUrl(primary.getUrl());
        dd.setUsername(primary.getUsername());
        dd.setPassword(primary.getPassword());
        return dd;
    }

    /**
     * 只读库  生产环境可以使用dns在多个读库中负载均衡
     */
    @Bean(name = "readDataSource")
//    @ConfigurationProperties(prefix = "datasource.read")
    public DataSource readDataSource() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>read datasource init.............");
//        return DataSourceBuilder.create().build();

        DriverManagerDataSource dd = new DriverManagerDataSource();
        dd.setDriverClassName(read.getDriver());
        dd.setUrl(read.getUrl());
        dd.setUsername(read.getUsername());
        dd.setPassword(read.getPassword());
        return dd;
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

    @Bean(name = "jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("dataSource") DynamicDataSource dataSource,
                                                                       @Qualifier("jpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean
                localContainerEntityManagerFactoryBean = builder.dataSource(dataSource).packages("com.zkgengkun.domain").build();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        Map<String, Object> jpaPropertyMap = Maps.newHashMap();
        jpaPropertyMap.put("javax.persistence.schema-generation.database.action", "none");
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "readJdbcTemplate")
    public JdbcTemplate readJdbcTemplate(@Qualifier("readDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    private Primary primary;
    private Read read;

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public Read getRead() {
        return read;
    }

    public void setRead(Read read) {
        this.read = read;
    }

    public static class Primary {

        private String url;
        private String username;
        private String password;
        private String driver;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }
    }
    public static class Read {

        private String url;
        private String username;
        private String password;
        private String driver;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }
    }

}

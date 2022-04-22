package com.example.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.example.hospital.config"})
@PropertySource("classpath:application.properties")
public class HibernateConfig {
    @Autowired
    private Environment enviroment;

    @Autowired
    private DataSource dataSource;

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", enviroment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", enviroment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", enviroment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        //Setting C3P0 properties
        // ref : https://www.mchange.com/projects/c3p0/
        properties.put("hibernate.c3p0.min_size", enviroment.getRequiredProperty("hibernate.c3p0.min_size"));
        properties.put("hibernate.c3p0.max_size", enviroment.getRequiredProperty("hibernate.c3p0.max_size"));
        properties.put("hibernate.c3p0.timeout", enviroment.getRequiredProperty("hibernate.c3p0.timeout"));
        properties.put("hibernate.c3p0.max_statements", enviroment.getRequiredProperty("hibernate.c3p0.max_statements"));
        properties.put("hibernate.c3p0.acquire_increment", enviroment.getRequiredProperty("hibernate.c3p0.acquire_increment"));

        return properties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform(enviroment.getRequiredProperty("hibernate.dialect"));

        return hibernateJpaVendorAdapter;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean  factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(this.jpaVendorAdapter());
        factoryBean.setDataSource(this.dataSource);
        factoryBean.setPackagesToScan("com.example.hospital.entities");
        factoryBean.setJpaProperties(this.hibernateProperties());
        factoryBean.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        /*
        Specify the JPA 2.0 validation mode for this persistence unit, overriding a value in persistence.xml if set.
        NOTE: Only applied if no external PersistenceUnitManager specified.
         */
        factoryBean.setValidationMode(ValidationMode.NONE);
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }



}

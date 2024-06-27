package com.training.java.springboot.casestudy.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Postgres2DataSourceConfig {


    @Primary
    @Bean("postgres2DataSourceProperties")
    @ConfigurationProperties("spring.datasource.pg2")
    public DataSourceProperties postgres2DataSourceProperties() {
        return new DataSourceProperties();
    }

    // @Bean
    // public DataSource paygwDataSource() {
    //     return paygwDataSourceProperties()
    //             .initializeDataSourceBuilder()
    //             .build();
    // }

    @Primary
    @Bean("postgres2DataSource")
    @ConfigurationProperties("spring.datasource.pg2.hikari")
    public DataSource postgres2DataSource() {
        return postgres2DataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Primary
    @Bean("postgres2JdbcTemplate")
    public JdbcTemplate postgres2JdbcTemplate(@Qualifier("postgres2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

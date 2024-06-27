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
public class PostgresDataSourceConfig {


    @Primary
    @Bean("postgresDataSourceProperties")
    @ConfigurationProperties("spring.datasource.pg")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    // @Bean
    // public DataSource paygwDataSource() {
    //     return paygwDataSourceProperties()
    //             .initializeDataSourceBuilder()
    //             .build();
    // }

    @Primary
    @Bean("postgresDataSource")
    @ConfigurationProperties("spring.datasource.pg.hikari")
    public DataSource postgresDataSource() {
        return postgresDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Primary
    @Bean("postgresJdbcTemplate")
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

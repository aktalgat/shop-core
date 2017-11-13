package com.tiksoft.shop.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DataSourceConfig extends HikariConfig {

    @Bean("ShopPostgresDS")
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }

    @Bean("ShopPostgres")
    public JdbcTemplate getJdbcTemplate(@Autowired @Qualifier("ShopPostgresDS") DataSource dsPrime) {
        return new JdbcTemplate(dsPrime);
    }

    @Bean("ShopPostgresNamed")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Autowired @Qualifier("ShopPostgresDS") DataSource dsPrime) {
        return new NamedParameterJdbcTemplate(dsPrime);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

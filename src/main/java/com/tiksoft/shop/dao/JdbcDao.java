package com.tiksoft.shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class JdbcDao {

    @Autowired
    protected DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    @Qualifier("ShopPostgres")
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("ShopPostgresNamed")
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcDao() {}

    public TransactionTemplate getTransactionTemplate() {
        return new TransactionTemplate(this.dataSourceTransactionManager);
    }
}

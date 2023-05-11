package cn.hlx.mybatis.session.defaults;

import cn.hlx.mybatis.executor.Executor;
import cn.hlx.mybatis.mapping.BoundSql;
import cn.hlx.mybatis.mapping.Environment;
import cn.hlx.mybatis.mapping.MappedStatement;
import cn.hlx.mybatis.session.Configuration;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.transaction.Transaction;
import cn.hlx.mybatis.transaction.TransactionFactory;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 默认SqlSession实现类
 * 
 * 
 *
 */
public class DefaultSqlSession implements SqlSession {
    
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
    
    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }
    
    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
    }
    
    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
    
    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
    
}
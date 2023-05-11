package cn.hlx.mybatis.session.defaults;

import cn.hlx.mybatis.executor.Executor;
import cn.hlx.mybatis.mapping.Environment;
import cn.hlx.mybatis.session.Configuration;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;
import cn.hlx.mybatis.session.TransactionIsolationLevel;
import cn.hlx.mybatis.transaction.Transaction;
import cn.hlx.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * 
 * 默认的 DefaultSqlSessionFactory 
 * 
 * 
 *
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    
    private final Configuration configuration;
    
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    
    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}

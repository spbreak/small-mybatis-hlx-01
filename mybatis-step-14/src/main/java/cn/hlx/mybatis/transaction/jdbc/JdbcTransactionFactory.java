package cn.hlx.mybatis.transaction.jdbc;

import cn.hlx.mybatis.session.TransactionIsolationLevel;
import cn.hlx.mybatis.transaction.Transaction;
import cn.hlx.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 
 * JdbcTransaction 工厂
 * 
 * 
 * 
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}

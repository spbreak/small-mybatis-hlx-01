package cn.hlx.mybatis.executor;

import cn.hlx.mybatis.mapping.BoundSql;
import cn.hlx.mybatis.mapping.MappedStatement;
import cn.hlx.mybatis.session.ResultHandler;
import cn.hlx.mybatis.session.RowBounds;
import cn.hlx.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * 执行器
 * 
 * 
 * 
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}

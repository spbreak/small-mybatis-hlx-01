package cn.hlx.mybatis.executor.keygen;

import cn.hlx.mybatis.executor.Executor;
import cn.hlx.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * 
 * 不用键值生成器
 * 
 * 
 * 
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}

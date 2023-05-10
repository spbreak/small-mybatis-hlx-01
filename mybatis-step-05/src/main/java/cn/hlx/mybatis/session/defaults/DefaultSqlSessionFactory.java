package cn.hlx.mybatis.session.defaults;

import cn.hlx.mybatis.session.Configuration;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;

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
        return new DefaultSqlSession(configuration);
    }
    
}

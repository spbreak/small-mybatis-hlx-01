package cn.hlx.mybatis.session.defaults;

import cn.hlx.mybatis.binding.MapperRegistry;
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
    
    private final MapperRegistry mapperRegistry;
    
    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }
    
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
    
}

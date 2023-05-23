package cn.hlx.mybatis.mapping;

/**
 * 
 * SQL源码
 * 
 * 
 * 
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}

package cn.hlx.mybatis.scripting;

import cn.hlx.mybatis.executor.parameter.ParameterHandler;
import cn.hlx.mybatis.mapping.BoundSql;
import cn.hlx.mybatis.mapping.MappedStatement;
import cn.hlx.mybatis.mapping.SqlSource;
import cn.hlx.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * 
 * 脚本语言驱动
 * 
 * 
 * 
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}

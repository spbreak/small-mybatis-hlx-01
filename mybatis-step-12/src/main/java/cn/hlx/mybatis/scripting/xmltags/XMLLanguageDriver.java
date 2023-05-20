package cn.hlx.mybatis.scripting.xmltags;

import cn.hlx.mybatis.executor.parameter.ParameterHandler;
import cn.hlx.mybatis.mapping.BoundSql;
import cn.hlx.mybatis.mapping.MappedStatement;
import cn.hlx.mybatis.mapping.SqlSource;
import cn.hlx.mybatis.scripting.LanguageDriver;
import cn.hlx.mybatis.scripting.defaults.DefaultParameterHandler;
import cn.hlx.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * 
 * XML语言驱动器
 * 
 * 
 * 
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}
package cn.hlx.mybatis.scripting;

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
    
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);
    
}

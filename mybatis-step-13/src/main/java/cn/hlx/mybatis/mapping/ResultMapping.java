package cn.hlx.mybatis.mapping;

import cn.hlx.mybatis.session.Configuration;
import cn.hlx.mybatis.type.JdbcType;
import cn.hlx.mybatis.type.TypeHandler;

/**
 * 
 * 结果映射
 * 
 * 
 * 
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}

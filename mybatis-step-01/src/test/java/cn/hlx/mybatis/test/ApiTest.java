package cn.hlx.mybatis.test;

import cn.hlx.mybatis.binding.MapperProxyFactory;
import cn.hlx.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 
 * 
 * 
 */

public class ApiTest {
    
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    
    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("cn.hlx.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作: 查询用户姓名");
        sqlSession.put("cn.hlx.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作: 查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);
        
        String res = userDao.queryUserName("10001");
        logger.info("测得结果: {}", res);
    }
    
    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, 
                (proxy, method, args) -> "你被代理了!");
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果: " + result);
    }

    public class TestGenericity<T> {
        public T testGenericityFun() {
            return (T) "1";
        }
    }
    
    
}



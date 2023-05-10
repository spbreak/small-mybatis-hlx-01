package cn.hlx.mybatis.test;

import cn.hlx.mybatis.datasource.pooled.PooledDataSource;
import cn.hlx.mybatis.io.Resources;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;
import cn.hlx.mybatis.session.SqlSessionFactoryBuilder;
import cn.hlx.mybatis.test.dao.IUserDao;
import cn.hlx.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        
        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}", JSON.toJSONString(user));
        }
    }
    
    @Test
    public void test_pooled() throws SQLException, InterruptedException {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://192.168.221.82:3306/mybatis?useUnicode=true");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("123456");
        // 持续获得链接
        while (true){
            Connection connection = pooledDataSource.getConnection();
            System.out.println(connection);
            Thread.sleep(1000);
            connection.close();
        }
    }

}

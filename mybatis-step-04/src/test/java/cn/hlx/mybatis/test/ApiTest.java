package cn.hlx.mybatis.test;

import cn.hlx.mybatis.builder.xml.XMLConfigBuilder;
import cn.hlx.mybatis.io.Resources;
import cn.hlx.mybatis.session.Configuration;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;
import cn.hlx.mybatis.session.SqlSessionFactoryBuilder;
import cn.hlx.mybatis.session.defaults.DefaultSqlSession;
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
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果: {}", JSON.toJSONString(user));
    }
    
    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();
        
        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);
        
        // 执行查询: 默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("cn.hlx.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果: {}", JSON.toJSONString(res));
    }

}
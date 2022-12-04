package cn.hlx.mybatis.test;

import cn.hlx.mybatis.test.dao.IActivityDao;
import cn.hlx.mybatis.test.dao.IUserDao;
import cn.hlx.mybatis.test.po.Activity;
import cn.hlx.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author 
 * @description 单元测试，源码对照测试类
 * @date 
 * @github 
 * 
 */
public class ApiTest {
    
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    
    @Test
    public void test_SqlSessionFactory() throws IOException {
        
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        // 2. 请求对象
        Activity req = new Activity();
        req.setActivityId(100001L);
        
        // 3. 第一组: SqlSession
        // 3.1 开启 Session
        SqlSession sqlSession01 = sqlSessionFactory.openSession();
        // 3.2 获取映射器对象
        IActivityDao dao01 = sqlSession01.getMapper(IActivityDao.class);
        logger.info("测试结果01: {}", JSON.toJSONString(dao01.queryActivityById(req)));
        sqlSession01.close();
        
        // 4. 第一组: SqlSession
        // 4.1 开启 Session
        SqlSession sqlSession02 = sqlSessionFactory.openSession();
        // 4.2 获取映射器对象
        IActivityDao dao02 = sqlSession02.getMapper(IActivityDao.class);
        logger.info("测试结果02: {}", JSON.toJSONString(dao02.queryActivityById(req)));
        sqlSession02.close();
    }
    
    @Test
    public void test_SqlSessionFactory_Annotation() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource-annotation.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        // 2. 开启 Session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        
        // 4. 测试验证
        List<User> users = userDao.queryUserInfoList();
        logger.info("测试结果: {}", JSON.toJSONString(users));
    }
    
}

package cn.hlx.mybatis.test;

import cn.hlx.mybatis.io.Resources;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;
import cn.hlx.mybatis.session.SqlSessionFactoryBuilder;
import cn.hlx.mybatis.test.dao.IActivityDao;
import cn.hlx.mybatis.test.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test_queryActivityById(){
        // 1. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);
        // 2. 测试验证
        Activity res = dao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}

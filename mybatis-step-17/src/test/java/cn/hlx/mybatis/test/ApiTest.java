package cn.hlx.mybatis.test;

import cn.hlx.mybatis.builder.xml.XMLConfigBuilder;
import cn.hlx.mybatis.executor.Executor;
import cn.hlx.mybatis.io.Resources;
import cn.hlx.mybatis.mapping.Environment;
import cn.hlx.mybatis.session.*;
import cn.hlx.mybatis.session.defaults.DefaultSqlSession;
import cn.hlx.mybatis.test.dao.IActivityDao;
import cn.hlx.mybatis.test.po.Activity;
import cn.hlx.mybatis.transaction.Transaction;
import cn.hlx.mybatis.transaction.TransactionFactory;
import com.alibaba.fastjson.JSON;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void test_queryActivityById() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);

        // 3. 测试验证
        Activity req = new Activity();
        req.setActivityId(100001L);
        Activity res = dao.queryActivityById(req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}

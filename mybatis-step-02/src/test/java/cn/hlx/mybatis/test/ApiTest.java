package cn.hlx.mybatis.test;

import cn.hlx.mybatis.binding.MapperRegistry;
import cn.hlx.mybatis.session.SqlSession;
import cn.hlx.mybatis.session.SqlSessionFactory;
import cn.hlx.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.hlx.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.hlx.mybatis.test.dao");
        
        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        
        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果: {}", res);
    }

}

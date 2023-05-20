package cn.hlx.mybatis.executor.result;

import cn.hlx.mybatis.reflection.factory.ObjectFactory;
import cn.hlx.mybatis.session.ResultContext;
import cn.hlx.mybatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 默认结果处理器
 * 
 * 
 * 
 */
public class DefaultResultHandler implements ResultHandler {

    private final List<Object> list;

    public DefaultResultHandler() {
        this.list = new ArrayList<>();
    }

    /**
     * 通过 ObjectFactory 反射工具类，产生特定的 List
     */
    @SuppressWarnings("unchecked")
    public DefaultResultHandler(ObjectFactory objectFactory) {
        this.list = objectFactory.create(List.class);
    }

    @Override
    public void handleResult(ResultContext context) {
        list.add(context.getResultObject());
    }

    public List<Object> getResultList() {
        return list;
    }

}

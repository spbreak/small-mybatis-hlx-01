package cn.hlx.mybatis.test.dao;

import cn.hlx.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Long activityId);

}

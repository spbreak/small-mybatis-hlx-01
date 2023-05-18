package cn.hlx.mybatis.test.dao;

import cn.hlx.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

    User queryUserInfo(User req);

}

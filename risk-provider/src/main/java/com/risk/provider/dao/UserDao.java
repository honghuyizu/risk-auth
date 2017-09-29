package com.risk.provider.dao;


import com.risk.provider.entity.User;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * 获取用户信息
     * @param name
     * @return
     */
    public  User getByName(String name);
}

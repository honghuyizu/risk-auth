package com.risk.api.dao;

import com.risk.api.entity.BaseUser;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface BaseUserDao extends BaseDao<BaseUser> {
    public  BaseUser getByName(String  name);
}

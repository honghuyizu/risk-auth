package com.risk.provider.service;

import com.risk.provider.model.UserDto;

/**
 * Created by Administrator on 2017/9/26.
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param name
     * @return
     */
    public UserDto getUser(String name);
}

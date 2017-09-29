package com.risk.provider.service.impl;

import com.risk.common.utils.MyBeanUtils;
import com.risk.provider.dao.UserDao;
import com.risk.provider.entity.User;
import com.risk.provider.service.UserService;
import com.risk.provider.model.UserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/26.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public UserDto getUser(String name) {
        UserDto userDto = new UserDto();
        User user = userDao.getByName(name);
        if(user != null){
            MyBeanUtils.copyBean2Bean(userDto, user);
        }
        return userDto;
    }
}

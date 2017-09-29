package com.risk.consumer.service.impl;

import com.risk.common.utils.IConstant;
import com.risk.common.utils.ResponseMessageUtil;
import com.risk.consumer.service.AwardService;
import com.risk.provider.model.UserDto;
import com.risk.provider.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2017/9/28.
 */
@Service
public class AwardServiceImpl implements AwardService {
    @Resource
    UserService userService;

    @Override
    public Response giveAward(String name) {
        javax.ws.rs.core.Response.Status st = null;
        ResponseMessageUtil responseMessageUtil = new ResponseMessageUtil();
        UserDto user = userService.getUser(name);
        responseMessageUtil.setResponseMessage(IConstant.Status.SUCCESS.getCode(), IConstant.Status.SUCCESS.getText(), user);
        st = IConstant.Status.SUCCESS.getHttpStatus();
        String result = responseMessageUtil.getResponseMessage();
        return Response.status(st).entity(result).build();
    }
}

package com.risk.api.service.impl;

import com.hsbank.util.tool.JsonUtil;
import com.hsbank.util.tool.redis.RedisUtil;
import com.risk.api.dao.BaseUserDao;
import com.risk.api.entity.BaseUser;
import com.risk.api.rabbitmq.Sender;
import com.risk.api.service.UserService;
import com.risk.common.utils.IConstant;
import com.risk.common.utils.ResponseMessageUtil;
import com.risk.provider.model.UserDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/3.
 */
@Service
public class UserServiceImpl  implements UserService{
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Resource
    public BaseUserDao baseUserDao;
    @Resource
    com.risk.provider.service.UserService userService;

    @Override

    public Response addUser(BaseUser user) {
        Response.Status st = null;
        ResponseMessageUtil responseMessageUtil = new ResponseMessageUtil();
        UserDto userDto = userService.getUser("洪湖");
        addUserInfo(user);
        responseMessageUtil.setResponseMessage(IConstant.Status.HOUTAI_YICHANG.getZhuangTaiMa(), IConstant.Status.HOUTAI_YICHANG.getHanYi(), "");
        st = IConstant.Status.HOUTAI_YICHANG.getHttpStatus();
        String result = responseMessageUtil.getResponseMessage();
        logger.info(result);
        logger.info("------注册接口结束------");
        return Response.status(st).entity(result).build();
    }


    public void addUserInfo(BaseUser user){
        baseUserDao.insert(user);
        int a = 1/0;
        logger.info("a::::"+a);
    }


    @Override
    public Response getUser( String name) {
        Sender sender = new Sender();
        Response.Status st = null;
        ResponseMessageUtil responseMessageUtil = new ResponseMessageUtil();
        Map<String, Object> cache = RedisUtil.getInstance().getMapObject(name);
        if(cache == null){
            Map map = new HashMap();
            map.put("name",name);
            map.put("age",30);
            RedisUtil.getInstance().setMapObject(name, map,3600);
        }
        //发送mq消息
        if(cache!=null){
            sender.sendDataToMQ(JsonUtil.toJson(cache));
        }
        UserDto userDto = userService.getUser("honghu");
        String userStrDto = JsonUtil.toJson(userDto);
        logger.info("userStrDto:::"+userStrDto);
        BaseUser user = new BaseUser();
        user = baseUserDao.getByName(name);
        String userStr = JsonUtil.toJson(user);
        logger.info("userStr:::"+userStr);
        responseMessageUtil.setResponseMessage(IConstant.Status.CHAXUN_CHENGGONG.getZhuangTaiMa(), IConstant.Status.CHAXUN_CHENGGONG.getHanYi(), user);
        st = IConstant.Status.CHAXUN_CHENGGONG.getHttpStatus();
        String result = responseMessageUtil.getResponseMessage();
        logger.info(result);
        return Response.status(st).entity(result).build();
    }
}

package com.risk.api.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/3.
 */
@RestController
@RequestMapping("/risk/api")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> List(){
        logger.info( "list controller..." );

        return null;

    }


}

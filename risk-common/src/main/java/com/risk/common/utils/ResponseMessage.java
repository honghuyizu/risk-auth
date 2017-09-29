package com.risk.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 异步记录日志.
 * <p>使用MQ记录日志信息</p>
 *
 */
@Data
public class ResponseMessage implements Serializable {

    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String text;
    /**
     * 后台响应时间
     */
    private String response_time;
    /**
     * 后台响应数据
     */
    private Object data;

    public ResponseMessage() {
    }

    public ResponseMessage(String code, String text, String response_time, Object data) {
        this.code = code;
        this.text = text;
        this.response_time = response_time;
        this.data = data;
    }

}

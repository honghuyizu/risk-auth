package com.risk.common.utils;

import javax.ws.rs.core.Response;

/**
 */

public class IConstant {
    /**
     * 自定义状态码枚举
     */
    public enum Status {
        SUCCESS("000", "查询成功", Response.Status.OK),
        PARA_ERROR("-1", "参数错误", Response.Status.BAD_REQUEST),
        EXCEPTION("-2", "后台异常", Response.Status.INTERNAL_SERVER_ERROR),;
        /**
         * 状态码
         */
        private final String code;
        /**
         * 状态码含义
         */
        private final  String text;
        /**
         * HTTP响应码
         */
        private final Response.Status httpStatus;

        Status(String code, String text, Response.Status httpStatus) {
            this.code = code;
            this.text = text;
            this.httpStatus = httpStatus;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }

        public Response.Status getHttpStatus() {
            return httpStatus;
        }
    }

}

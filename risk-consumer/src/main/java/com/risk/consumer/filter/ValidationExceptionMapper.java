package com.risk.consumer.filter;

import com.alibaba.dubbo.rpc.protocol.rest.RestConstraintViolation;
import com.alibaba.dubbo.rpc.protocol.rest.RpcExceptionMapper;
import com.alibaba.dubbo.rpc.protocol.rest.ViolationReport;
import com.risk.common.utils.IConstant;
import com.risk.common.utils.ResponseMessageUtil;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;

/**
 *
 */
public class ValidationExceptionMapper extends RpcExceptionMapper {
    protected Response handleConstraintViolationException(ConstraintViolationException cve) {
        Response.Status status = null;
        ResponseMessageUtil responseMessageUtil = new ResponseMessageUtil();
        ViolationReport report = new ViolationReport();
        for (ConstraintViolation cv : cve.getConstraintViolations()) {
            report.addConstraintViolation(new RestConstraintViolation(
                    cv.getPropertyPath().toString(),
                    cv.getMessage(),
                    cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString()));
        }
        try {
            responseMessageUtil.setResponseMessage( IConstant.Status.CANSHU_CUOWU.getZhuangTaiMa(),
                    IConstant.Status.CANSHU_CUOWU.getHanYi(), report);
            status = Response.Status.BAD_REQUEST;
        } catch (Exception e) {
            responseMessageUtil.setResponseMessage(IConstant.Status.HOUTAI_YICHANG.getZhuangTaiMa());
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }

        String result = responseMessageUtil.getResponseMessage();

        return Response.status(status).entity(result).build();
    }
}

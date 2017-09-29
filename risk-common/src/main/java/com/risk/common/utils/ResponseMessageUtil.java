package com.risk.common.utils;


import com.alibaba.fastjson.JSON;

/**
 * 异步记录日志.
 * <p>使用MQ记录日志信息</p>
 */
public class ResponseMessageUtil {

    private ResponseMessage responseMessage = new ResponseMessage();

    public void setResponseMessage(String zhuangTaiMa, String tiShiXinXi, String xiangYingShiJian, Object xiangYingShuJu) {
        responseMessage.setZhuangTaiMa(zhuangTaiMa);
        responseMessage.setTiShiXinXi(tiShiXinXi);
        responseMessage.setXiangYingShiJian(xiangYingShiJian);
        responseMessage.setXiangYingShuJu(xiangYingShuJu);
    }

    public void setResponseMessage(String zhuangTaiMa, String tiShiXinXi, String xiangYingShuJu) {
        this.setResponseMessage(zhuangTaiMa, tiShiXinXi, DateTimeHelper.getCurrentDateTime(), xiangYingShuJu);
    }


    public void setResponseMessage(String zhuangTaiMa, String tiShiXinXi, Object xiangYingShuJu) {
        this.setResponseMessage(zhuangTaiMa, tiShiXinXi, DateTimeHelper.getCurrentDateTime(), xiangYingShuJu);
    }

    public String getResponseMessage() {
        return JSON.toJSONString(responseMessage);
    }

    public void setResponseMessage(String zhuangTaiMa) {
        String tiShiXinXi = "";
        String xiangYingShuJu = "";
        if (null != zhuangTaiMa && zhuangTaiMa.equals(IConstant.Status.CANSHU_CUOWU.getZhuangTaiMa())) {
            tiShiXinXi = IConstant.Status.CANSHU_CUOWU.getHanYi();
        }
        if (null != zhuangTaiMa && zhuangTaiMa.equals(IConstant.Status.HOUTAI_YICHANG.getZhuangTaiMa())) {
            tiShiXinXi = IConstant.Status.HOUTAI_YICHANG.getHanYi();
        }
        this.setResponseMessage(zhuangTaiMa, tiShiXinXi, DateTimeHelper.getCurrentDateTime(), xiangYingShuJu);
    }
}

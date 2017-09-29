package com.risk.common.utils;

import java.io.Serializable;

/**
 * 异步记录日志.
 * <p>使用MQ记录日志信息</p>
 *
 */
public class ResponseMessage implements Serializable {

    /**
     * 状态码
     */
    private String zhuangTaiMa;
    /**
     * 提示信息
     */
    private String tiShiXinXi;
    /**
     * 后台响应时间
     */
    private String xiangYingShiJian;
    /**
     * 后台响应数据
     */
    private Object xiangYingShuJu;

    public ResponseMessage() {
    }

    public ResponseMessage(String zhuangTaiMa, String tiShiXinXi, String xiangYingShiJian, Object xiangYingShuJu) {
        this.zhuangTaiMa = zhuangTaiMa;
        this.tiShiXinXi = tiShiXinXi;
        this.xiangYingShiJian = xiangYingShiJian;
        this.xiangYingShuJu = xiangYingShuJu;
    }

    public String getZhuangTaiMa() {
        return zhuangTaiMa;
    }

    public void setZhuangTaiMa(String zhuangTaiMa) {
        this.zhuangTaiMa = zhuangTaiMa;
    }

    public String getTiShiXinXi() {
        return tiShiXinXi;
    }

    public void setTiShiXinXi(String tiShiXinXi) {
        this.tiShiXinXi = tiShiXinXi;
    }

    public String getXiangYingShiJian() {
        return xiangYingShiJian;
    }

    public void setXiangYingShiJian(String xiangYingShiJian) {
        this.xiangYingShiJian = xiangYingShiJian;
    }

    public Object getXiangYingShuJu() {
        return xiangYingShuJu;
    }

    public void setXiangYingShuJu(Object xiangYingShuJu) {
        this.xiangYingShuJu = xiangYingShuJu;
    }
}

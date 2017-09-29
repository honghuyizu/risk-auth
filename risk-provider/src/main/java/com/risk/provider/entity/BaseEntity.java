package com.risk.provider.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/1.
 */
public abstract class BaseEntity<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    protected String remark              ;
    protected Date endDt              ;
    protected Date createDt           ;
    protected Integer lastUpdateUserId ;
    protected Date lastUpdateDt      ;
    protected String deleteFlag         ;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}

package com.ant.sofastack.facade.model;

import java.io.Serializable;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
public class TradeRes implements Serializable {
    private static final long serialVersionUID = -7691230178255207640L;

    private Integer status;

    private String failReason;

    //....

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return "TradeRes{" +
                "status=" + status +
                ", failReason='" + failReason + '\'' +
                '}';
    }
}

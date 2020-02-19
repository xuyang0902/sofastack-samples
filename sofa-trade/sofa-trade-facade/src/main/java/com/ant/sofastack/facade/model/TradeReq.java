package com.ant.sofastack.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
public class TradeReq implements Serializable {

    private static final long serialVersionUID = -8464445596942614003L;

    private String token;

    private String userId;

    private String productId;

    private BigDecimal amount;

    //...


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TradeReq{" +
                "token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", amount=" + amount +
                '}';
    }
}

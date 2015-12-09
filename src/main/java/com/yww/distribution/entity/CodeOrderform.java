/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.entity;

import java.util.Date;

public class CodeOrderform {

    /**
     * 主键
     */
    private String id;
    /**
     * 串码
     */
    private String code;
    /**
     * 商品数量
     */
    private Integer amount;
    /**
     * 有效截至日期 TODO
     */
    private Date endtime;
    /**
     * 平台id
     */
    private String externalId;

    /**
     * 订单状态 1 有效（未核销） 2 无效（已经核销）
     */
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id == null ? null : id.trim();
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code == null ? null : code.trim();
    }

    public Integer getAmount() {

        return amount;
    }

    public void setAmount(Integer amount) {

        this.amount = amount;
    }

    public Date getEndtime() {

        return endtime;
    }

    public void setEndtime(Date endtime) {

        this.endtime = endtime;
    }

    public String getExternalId() {

        return externalId;
    }

    public void setExternalId(String externalId) {

        this.externalId = externalId == null ? null : externalId.trim();
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state == null ? null : state.trim();
    }
}
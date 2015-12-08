/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.generate.dto;

import java.util.Date;

import com.yww.distribution.base.dto.BaseDto;

/**
 * <strong>获取ticket参数实体。</strong>
 * <p>
 * 具体参数待确定
 * </p>
 *
 * @author ansh
 */
public class GenerateCodeParamDto extends BaseDto {

    /**
     * 平台id
     */
    private String externalId;
    
    /**
     * 订单商品数量
     */
    private String amount;
    
    /**
     * 有效截至日期
     */
    private Date endtime;

    public String getExternalId() {

        return externalId;
    }

    public void setExternalId(String externalId) {

        this.externalId = externalId;
    }

    public String getAmount() {

        return amount;
    }

    public void setAmount(String amount) {

        this.amount = amount;
    }

    
    /**
     * @return the endtime
     */
    public Date getEndtime() {
    
        return endtime;
    }

    
    /**
     * @param endtime the endtime to set
     */
    public void setEndtime(Date endtime) {
    
        this.endtime = endtime;
    }

}

/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.entity;

public class CodePool {

    /**
     * 串码
     */
    private String code;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code == null ? null : code.trim();
    }

    public CodePool(String code) {
        this.code = code == null ? null : code.trim();
    }
}
/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.base.util;

import java.util.UUID;

/**
 * <strong>UUID工具类。</strong>
 *
 * @author yw
 */
public class UUIDUtils {

    /**
     * <strong>获取不带'-'的UUID。</strong>
     *
     * @return UUID字符串
     * @author yw
     */
    public static String getUUID() {

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("\\-", "");
        return uuid;
    }
}

/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.generate.service;

import java.util.Date;

/**
 * <strong>自动生成串码，取串码方法等服务类。</strong>
 *
 * @author ansh
 */
public interface ICodePoolService {

    /**
     * <strong>自动生成若干不重复的随机串码</strong>
     * <p>
     * 自动生成若干不重复的随机串码，
     * 生成串码数量取决于配置的串码表最大值与当前串码表的数量差
     * 即串码表的数量始终保持在设置的 串码表最大值 个串码
     * 1、获取code_pool串码表中所有条数总数量
     * 2、从数据库中取出所有未使用和使用中的码，已经核销的码不在范围中
     * 3、根据当前code_pool表中的现有数量，生成若干个不与现有的码重复的随机码存到数据库
     * </p>
     * 
     * @author ansh
     */
    void autoCreateCodeInsertTypeBatch();

    /**
     * <strong>自动生成若干不重复的随机串码</strong>
     * <p>
     * 自动生成若干不重复的随机串码，
     * 生成串码数量取决于配置的串码表最大值与当前串码表的数量差
     * 即串码表的数量始终保持在设置的 串码表最大值 个串码
     * 1、获取code_pool串码表中所有条数总数量
     * 2、从数据库中取出所有未使用和使用中的码，已经核销的码不在范围中
     * 3、根据当前code_pool表中的现有数量，生成若干个不与现有的码重复的随机码存到数据库
     * </p>
     * 
     * @author ansh
     */
    void autoCreateCodeInsertTypeSingle();

    /**
     * <strong>获取随机串码（参数待定）</strong>
     * <p>
     * 从随机串码表中取出第一条记录，并删除该表中的这条记录
     * 将随机码连同其他信息生成订单信息 存入订单表 返回随机码
     * </p>
     * ，
     * 
     * @param externalId
     *            平台id
     * @param endtime
     *            有效截至日期
     * @param amount
     *            订单票数量
     * @return
     * @author ansh
     */
    String getCode(String externalId, Date endtime, int amount);
}

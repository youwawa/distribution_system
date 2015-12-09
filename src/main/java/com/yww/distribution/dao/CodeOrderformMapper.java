/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.dao;

import java.util.Set;

import com.yww.distribution.entity.CodeOrderform;

public interface CodeOrderformMapper {

    int deleteByPrimaryKey(String id);

    int insert(CodeOrderform record);

    int insertSelective(CodeOrderform record);

    CodeOrderform selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CodeOrderform record);

    int updateByPrimaryKey(CodeOrderform record);

    /**
     * <strong>查询所有已发出但并未消码的随机串码 state＝1。</strong>
     *
     * @return
     * @author ansh
     */
    Set<String> selectAllUsing();
}
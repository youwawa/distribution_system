/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.dao;

import java.util.Set;

import com.yww.distribution.entity.CodeOrderform;

public interface CodeOrderformMapper {

    /**
     * <strong>根据主键删除一条记录。</strong>
     *
     * @return
     * @author ansh
     */
    int deleteByPrimaryKey(String id);

    /**
     * <strong>新增一条记录。</strong>
     *
     * @return
     * @author ansh
     */
    int insert(CodeOrderform record);

    /**
     * <strong>插入一条记录，若该对象某个字段为空，则不插入该字段。</strong>
     *
     * @return
     * @author ansh
     */
    int insertSelective(CodeOrderform record);

    /**
     * <strong>根据主键查询一条记录。</strong>
     *
     * @return
     * @author ansh
     */
    CodeOrderform selectByPrimaryKey(Integer id);

    /**
     * <strong>更新一条记录，若该对象某个字段为空，则不更新该字段。</strong>
     *
     * @return
     * @author ansh
     */
    int updateByPrimaryKeySelective(CodeOrderform record);

    /**
     * <strong>根据主键更新一条记录。</strong>
     *
     * @return
     * @author ansh
     */
    int updateByPrimaryKey(CodeOrderform record);

    /**
     * <strong>查询所有已发出但并未消码的随机串码 state＝1。</strong>
     *
     * @return
     * @author ansh
     */
    Set<String> selectAllUsing();
}
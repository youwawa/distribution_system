/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.dao;

import java.util.List;
import java.util.Set;

/**
 * <strong>code_pool表数据操作。</strong>
 *
 * @author ansh
 */
public interface CodePoolMapper {

    /**
     * <strong>根据一个list集合批量存储到数据库code_pool表中。</strong>
     *
     * @param codeList
     * @return
     * @author ansh
     */
    int insertCodeByList(List<String> codeList);

    /**
     * <strong>将一个code值insert到数据库。</strong>
     *
     * @param code
     * @return
     * @author ansh
     */
    int insertCode(String code);

    /**
     * <strong>从code_pool表中查询第一条记录的code值。</strong>
     *
     * @return
     * @author ansh
     */
    String selectFirstCode();

    /**
     * <strong>根据code删除code_pool表中的一条记录。</strong>
     *
     * @param code
     * @return
     * @author ansh
     */
    int deleteByCode(String code);

    /**
     * <strong>查询code_pool表中所有code。</strong>
     *
     * @return
     * @author ansh
     */
    Set<String> selectAll();

    /**
     * <strong>获取code_pool表的数据条数。</strong>
     *
     * @return
     * @author ansh
     */
    int getCodeCount();
}
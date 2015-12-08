package com.yww.distribution.dao;

/**
 * <strong>code_pool表数据操作。</strong>
 *
 * @author ansh
 */
public interface TestCodePoolMapper {

    /**
     * <strong>将一个code值insert到数据库。</strong>
     *
     * @param code
     * @return
     * @author ansh
     */
    int insertCode(String code);
}
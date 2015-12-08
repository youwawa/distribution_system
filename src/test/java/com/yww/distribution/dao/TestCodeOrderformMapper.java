package com.yww.distribution.dao;

import java.util.ArrayList;

import com.yww.distribution.entity.CodeOrderform;

public interface TestCodeOrderformMapper {

    /**
     * <strong>查询所有纪录</strong>
     *
     * @return
     * @author yw
     */
    ArrayList<CodeOrderform> selectAll();
}
/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.schedule;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.yww.distribution.dao.CodePoolMapper;
import com.yww.distribution.dao.TestCodeOrderformMapper;
import com.yww.distribution.generate.service.ICodePoolService;

import test.base.TestBase;

/**
 * <strong>测试自动生成串码。</strong>
 * <p>
 * </p>
 *
 * @author ansh
 */
public class TestAutoCreateCodeController extends TestBase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ICodePoolService codePoolService;

    @Resource
    private TestCodeOrderformMapper codeOrderform;
    @Resource
    private CodePoolMapper codePooldao;

    /**
     * 获取配置文件中的codePool串码表设置的同时存放串码最大数量
     */
    @Value("${code-config.codePoolMaxSize}")
    private int codePoolMaxSize;

    @Test
    public void testAutoCreateCodeInsertTypeBatch() throws Exception {
        // 准备数据
        // 执行测试
        // 对比期待值

        long beginTime = new Date().getTime();
        codePoolService.autoCreateCodeInsertTypeBatch();
        // codePoolService.autoCreateCode("batchInsert");
        long endTime = new Date().getTime();
        // 获取成随机码后数据库codepool表中当前数据条数
        int afterCodePoolCount = codePooldao.getCodeCount();
        logger.info("testAutoCreateCodeInsertTypeBatch 用时："+((endTime - beginTime) + " ms"));
        assertEquals(codePoolMaxSize, afterCodePoolCount);
    }

    @Test
    public void testAutoCreateCodeInsertTypeSingle() throws Exception {
        // 准备数据
        // 执行测试
        // 对比期待值

        long beginTime = new Date().getTime();
        codePoolService.autoCreateCodeInsertTypeSingle();
        // codePoolService.autoCreateCode("batchInsert");
        long endTime = new Date().getTime();
        // 获取成随机码后数据库codepool表中当前数据条数
        int afterCodePoolCount = codePooldao.getCodeCount();
        logger.info("testAutoCreateCodeInsertTypeSingle 用时："+((endTime - beginTime) + " ms"));
        assertEquals(codePoolMaxSize, afterCodePoolCount);
    }
}

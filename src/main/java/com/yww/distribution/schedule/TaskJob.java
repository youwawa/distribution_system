/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.schedule;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yww.distribution.generate.service.ICodePoolService;

/**
 * <strong>定时任务。</strong>
 *
 * @author ansh
 */
@Component("taskjob")
public class TaskJob {

    @Resource
    private ICodePoolService codePoolService;

    /**
     * <strong>每天晚上2点自动生成随机码</strong>
     * <p>
     * 
     * @Scheduled(cron = "0 0 2 * * ?") 每天晚上2点
     * @Scheduled(cron = "0 * * * * ?")每隔一分钟自动生成随机码 测试用
     *                 </p>
     * @author ansh
     */
    @Scheduled(cron = "0 * * * * ?")
    public void autoCreateCodeJob() {

        codePoolService.autoCreateCodeInsertTypeSingle();
    }
}

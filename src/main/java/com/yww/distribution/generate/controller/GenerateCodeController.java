/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.generate.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yww.distribution.generate.dto.GenerateCodeParamDto;
import com.yww.distribution.generate.dto.GenerateCodeResultDto;
import com.yww.distribution.generate.service.ICodePoolService;

@Controller
@RequestMapping("/generate")
public class GenerateCodeController {

    @Resource
    private ICodePoolService codePoolService;

    /**
     * <strong>获取随机串码接口。</strong>
     * <p>
     * 调用接口放提供一些订单信息并存入订单表，返回给订单方一个随机串码
     * </p>
     *
     * @param externalId
     *            平台id
     * @param amount
     *            商品数量
     * @return
     * @author ansh
     * @throws Exception 
     */
    @RequestMapping("/ticket")
    @ResponseBody
    public GenerateCodeResultDto ticket(GenerateCodeParamDto paramDto) throws Exception {
        
        // TODO 参数校验

        String code = codePoolService.getCode(paramDto.getExternalId(), paramDto.getEndtime(), Integer.parseInt(paramDto.getAmount()));

        GenerateCodeResultDto res = new GenerateCodeResultDto();
        res.setCode(code);
        return res;
    }

    /**
     * <strong>生成串码测试。</strong>
     * <p>
     * </p>
     *
     * @return
     * @author ansh
     */
    // @RequestMapping("/createCode")
    // @ResponseBody
    // public Map<String, String> createCode() {
    //
    // long begin = new Date().getTime();
    // codePoolService.autoCreateCode();
    // long end = new Date().getTime();
    // Map<String, String> map = new HashMap<>();
    // map.put("time", end - begin + " ms");
    // return map;
    // }

}

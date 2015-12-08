package com.yww.distribution.generate.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.yww.distribution.dao.TestCodeOrderformMapper;
import com.yww.distribution.dao.TestCodePoolMapper;
import com.yww.distribution.entity.CodeOrderform;
import com.yww.distribution.generate.dto.GenerateCodeResultDto;

import test.base.TestBase;


public class TestGetCodeController extends TestBase{

    @Resource
    private TestCodePoolMapper codePool;
    
    @Resource
    private TestCodeOrderformMapper codeOrderform;

    
    @Test
    public void testGetCode1() throws Exception {
        
        // 插入准备数据
        codePool.insertCode("1234567890");
        
        // 调用请求
        MockHttpServletRequestBuilder builder = post("/generate/ticket");
        builder.param("externalId", "111");
        builder.param("amount", "5");
        MvcResult result = mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        
        ObjectMapper objectMapper = new ObjectMapper();
        GenerateCodeResultDto ret2 = objectMapper.readValue(result.getResponse().getContentAsString(), GenerateCodeResultDto.class);
        
        // 断言
        assertEquals("1234567890", ret2.getCode());
        
        ArrayList<CodeOrderform> list = (ArrayList<CodeOrderform>) codeOrderform.selectAll();
        
        assertEquals(1, list.size());
        
        assertEquals("1234567890", list.get(0).getCode());
        assertEquals("1", list.get(0).getState());
        
    }
    

}

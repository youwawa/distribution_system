/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package test.base;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * <strong>unit测试基类。</strong>
 *
 * @author yw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/beans/applicationContext.xml",
        "classpath:/beans/spring-controller.xml" }, inheritLocations = false)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class TestBase {

    // import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
    // import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
    // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
    // import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp() {

        mockMvc = webAppContextSetup(wac).build();
    }
}

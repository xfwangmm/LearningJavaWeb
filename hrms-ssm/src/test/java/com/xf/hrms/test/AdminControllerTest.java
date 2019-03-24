package com.xf.hrms.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
public class AdminControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        RequestBuilder request = post("/admin/login")
                .param("username", "name")
                .param("password", "pwd");
        mvc.perform(request).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testAdminList() throws Exception {
        mvc.perform(get("/admin/list").param("name", "new")).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testAdminCount() throws Exception {
        mvc.perform(get("/admin/count").param("name", "")).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testAdd() throws Exception {
        mvc.perform(post("/admin/add")
                .param("username", "xf")
                .param("password", "123456")
                .param("userRole", "root")).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDelete() throws Exception {
        mvc.perform(delete("/admin/delete")
                .param("id", "1")).andDo(MockMvcResultHandlers.print());
    }

}

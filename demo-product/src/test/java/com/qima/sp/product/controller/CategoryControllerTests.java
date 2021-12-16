package com.qima.sp.product.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Yulong
 * @date 2021/12/9 16:28
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testDetail() throws Exception {
        String url = "/category/{id}";
        mockMvc.perform(MockMvcRequestBuilders.get(url, "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{'status':'ACTIVE'}"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}

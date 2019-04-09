package com.kasiyanov.internationalizationdatabase.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void checkGetItemByRussinLanguage() throws Exception {
        MockHttpServletRequestBuilder post = post("/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"language\": \"RU\", " +
                        "\"code\": \"1\"" +
                        "}");

        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        "{'itemName':'Телефон', " +
                                "'attributeNames': " +
                                "[" +
                                "'Модель', " +
                                "'Производитель', " +
                                "'Размер экрана'" +
                                "]" +
                                "}"));
    }

    @Test
    public void checkGetItemByEnglishLanguage() throws Exception {
        MockHttpServletRequestBuilder post = post("/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"language\": \"EN\", " +
                        "\"code\": \"1\"" +
                        "}");

        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        "{'itemName':'Telephone', " +
                                "'attributeNames': " +
                                "[" +
                                "'Model', " +
                                "'Manufacture', " +
                                "'Screen size'" +
                                "]" +
                                "}"));
    }
}

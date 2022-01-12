package com.web.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HomeController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@WithMockUser //TODO : mock 이용 테스트에 SpringSecurity 적용
//https://imbf.github.io/spring/2020/08/18/Test-Spring-MVC-Controller-Applying-Spring-Security.html

public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("메인 페이지 접속")
    public void home() throws Exception {

        mvc.perform(get("/"))
                .andExpect(status().isOk());

    }

}

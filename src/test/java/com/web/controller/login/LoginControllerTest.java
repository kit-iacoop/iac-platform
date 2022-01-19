package com.web.controller.login;

import com.web.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LoginController.class})
@WebAppConfiguration
@AutoConfigureMockMvc
//@WebMvcTest(controllers = LoginController.class)

public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void loginTest() throws Exception{
        //given
        String url = "/login";

        //when
        mvc.perform(get(url))
                //then
                .andExpect(status().isOk());


    }

    @WithMockUser
    @Test
    public void accessDeniedTest() throws Exception{

        //given
        String url = "/denied";

        //when
        mvc.perform(get(url))
                //then
                .andExpect(status().isOk());

    }

    @WithMockUser
    @Test
    public void logoutTest() throws Exception {

        //given
        String url = "/logout";

        //when
        mvc.perform(get(url))
                .andExpect(status().isOk())
                ;

    }
}

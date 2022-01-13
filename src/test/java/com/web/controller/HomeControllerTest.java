package com.web.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) //  Spring Bean 테스트하기 위해서 필요
@ContextConfiguration(classes = {HomeController.class}) // 테스트를 위해 ApplicationContext 설정, 로드 방법 정의 사용되는 메타데이터 정의
@WebAppConfiguration    //web과 연관된 구성요소들(controller, view resolver, …)등 다루는 기능 제공
@AutoConfigureMockMvc   //자동으로 MockMvc를 사용해서 테스트할 수 있게끔 설정
@WithMockUser

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

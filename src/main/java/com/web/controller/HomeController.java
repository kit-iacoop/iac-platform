package com.web.controller;

import com.common.Common;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Slf4j
@Controller

public class HomeController {

    private final Common common;

    @GetMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping( "/register")
    public String register() {
        return "register/main";
    }

    @GetMapping(path = {"/company", "/professor", "/officer"})
    public String accountHome(HttpServletRequest req) {
        return (common.getReqUrlPrefix(req) +"/main");
    }


}

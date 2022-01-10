package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login.do")
    public String login() {
        return "login/login";
    }

    @RequestMapping(value = "/register")
    public String signup() {
        return "signup/main";
    }

    @RequestMapping(value = "/register/company")
    public String signupCompany() {
        return "signup/company";
    }
}
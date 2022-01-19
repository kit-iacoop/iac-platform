package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping( "/register")
    public String register() {
        return "register/main";
    }

    @GetMapping("/company")
    public String companyHome() {
        return "company/main";
    }

    @GetMapping("/professor")
    public String professorHome() {
        return "professor/main";
    }

    @GetMapping("/officer")
    public String officerHome() {
        return "officer/main";
    }


}

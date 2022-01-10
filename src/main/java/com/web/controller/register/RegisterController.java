package com.web.controller.register;


import com.web.dto.CompanyRegisterVO;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @GetMapping( "/register")
    public String register() {
        return "register/main";
    }

    @GetMapping("/register/company")
    public ModelAndView createCompany(){
        return new ModelAndView("register/company").addObject(new CompanyRegisterVO());
    }

    @PostMapping("/register/company")
    public String createCompany(@ModelAttribute CompanyRegisterVO companyRegisterVO){
        // TODO : 성공, 실패 분기 必

        return "register/company";
    }




}

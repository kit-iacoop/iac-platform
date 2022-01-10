package com.web.controller.Account;


import com.domain.Account.Account;
import com.web.dto.CompanyRegisterVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

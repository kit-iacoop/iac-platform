package com.web.controller.account;


import com.common.Common;
import com.domain.account.Company;
import com.domain.common.State;
import com.web.dto.CompanyRegisterDTO;
import com.web.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor


@Slf4j
@Controller
public class AccountController {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;
    private final Common common;

    @GetMapping( "/register")
    public String register() {
        return "register/main";
    }

    @GetMapping("/register/company")
    public ModelAndView createCompany(){
        return new ModelAndView("register/company").addObject(new CompanyRegisterDTO());
    }

    @PostMapping("/register/company")
    public ModelAndView createCompany(@Validated @ModelAttribute CompanyRegisterDTO companyDTO, Errors errors, ModelAndView mav){

        if(errors.hasErrors()) {
            mav.setViewName("/register/company");
            mav.addObject("errors", common.refineErrors(errors));
            return mav;
        }


        Company companyEntity = companyDTO.toEntity();
        companyEntity.verification("BRONZE", 0L, 0L, State.NORMAL); //TODO : 가입 승인 페이지 생길 때 까지..
        accountService.createAccount(companyEntity);

        mav.setViewName("redirect:/");


        return mav;
    }


}

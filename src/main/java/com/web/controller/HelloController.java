package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/moveLogin.do")
    private ModelAndView moveLogin(@ModelAttribute LoginVO loginVO, HttpServletRequest request) throws Exception {
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/login.do")
    private ModelAndView doLogin(LoginVO loginVO, BindingResult result,
     RedirectAttributes redirect, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("--------------login!!!!");
        System.out.println("--------------" + loginVO.getLoginId());
        System.out.println("--------------" + loginVO.getPassword());
        System.out.println("--------------login!!!!");
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/register")
    public String signup() {
        return "signup/main";
    }

    @RequestMapping(value = "/register/form/company")
    private ModelAndView moveLogin(@ModelAttribute CompanyRegisterVO companyRegisterVO, HttpServletRequest request) throws Exception {
        return new ModelAndView("signup/company");
    }

    @RequestMapping(value = "/register/company")
    public String doSignupCompany(CompanyRegisterVO companyRegisterVO,  BindingResult result,
    RedirectAttributes redirect, HttpServletResponse response,HttpServletRequest request) throws Exception {
        System.out.println("--------------signup!!!!");
        System.out.println("--------------" + companyRegisterVO.getLoginId());
        System.out.println("--------------" + companyRegisterVO.getPassword());
        System.out.println("--------------" + companyRegisterVO.getName());
        System.out.println("--------------" + companyRegisterVO.getBirthDate());
        System.out.println("--------------" + companyRegisterVO.getZipCode());
        System.out.println("--------------" + companyRegisterVO.getCity());
        System.out.println("--------------" + companyRegisterVO.getStreet());
        System.out.println("--------------" + companyRegisterVO.getEmail());
        System.out.println("--------------" + companyRegisterVO.getTelephone());
        System.out.println("--------------" + companyRegisterVO.getStatus());
        System.out.println("--------------" + companyRegisterVO.getEmployeeNumber());
        System.out.println("--------------" + companyRegisterVO.getSector());
        System.out.println("--------------" + companyRegisterVO.getOwner());
        System.out.println("--------------" + companyRegisterVO.getCompanyType());
        System.out.println("--------------" + companyRegisterVO.getSubscriptionDate());
        System.out.println("--------------signup!!!!");
        return "signup/company";
    }
}
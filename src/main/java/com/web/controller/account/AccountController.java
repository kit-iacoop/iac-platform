package com.web.controller.account;


import com.common.Common;
import com.domain.account.Account;
import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.account.Professor;
import com.domain.common.State;
import com.security.service.AccountContext;
import com.web.dto.account.CompanyInformationDTO;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@AllArgsConstructor
@Slf4j
@Controller
public class AccountController {

    private final AccountService accountService;
    private final Common common;

    @GetMapping("/register/company")
    public ModelAndView registerCompany(){
        return new ModelAndView("register/company").addObject(new CompanyInformationDTO());
    }

    @PostMapping("/register/company")
    public ModelAndView registerCompany(@Validated @ModelAttribute CompanyInformationDTO companyDTO, Errors errors, ModelAndView mav){

        if(errors.hasErrors()) {

            LinkedList<LinkedHashMap<String, String>> errorList = common.refineErrors(errors);
            log.warn("COMPANY 회원가입 예외 : " + errorList.toString()); //FE 필터 거치지 않았으므로 WARN으로 기록

            mav.setViewName("register/company");
            mav.addObject("errors", errorList);

            return mav;
        }


        Company companyEntity = companyDTO.toEntity();
        companyEntity.verification("BRONZE", 0L, 0L, State.NORMAL); //TODO : 가입 승인 페이지 생길 때 까지..
        accountService.createAccount(companyEntity);
        mav.setViewName("register/success");

        return mav;
    }

    @GetMapping("officer/family-company/registration-screening")
    public ModelAndView companyRegistrationScreen(ModelAndView mav){

        mav.addObject("companyDtos", accountService.getAllPendingCompanies());
        mav.setViewName("officer/family-company-accept/register");

        return mav;
    }


    @GetMapping(path = {"officer/mypage", "company/mypage", "professor/mypage"})
    public ModelAndView mypage(HttpServletRequest req, ModelAndView mav){

        Account account = ((AccountContext)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAccount();

        mav.addObject("account", account.toInformationDTO());

        mav.setViewName(common.getReqUrlPrefix(req) + "/mypage/inquire-info");

        return mav;
    }

    @GetMapping(path ={"company/mypage/update", "professor/mypage/update", "officer/mypage/update" })
    public ModelAndView updateInformation(HttpServletRequest req, ModelAndView mav){

        Account account = ((AccountContext)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAccount();

        mav.addObject("account", account.toInformationDTO());

        mav.setViewName(common.getReqUrlPrefix(req) + "/mypage/update-info");

        return mav;
    }

}

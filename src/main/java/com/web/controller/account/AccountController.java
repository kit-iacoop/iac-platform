package com.web.controller.account;


import com.common.Common;
import com.domain.account.Account;
import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.account.Professor;
import com.domain.common.State;
import com.security.service.AccountContext;
import com.web.dto.account.CompanyInformationDTO;
import com.web.dto.account.*;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Controller
public class AccountController {

    private final AccountService accountService;
    private final Common common;

    @GetMapping("/register")
    public ModelAndView registerCompany(){
        return new ModelAndView("register/company").addObject(new CompanyInformationDTO());
    }

    @PostMapping("/register")
    public ModelAndView registerCompany(@Validated @ModelAttribute CompanyInformationDTO companyDTO, Errors errors, ModelAndView mav) {

        if (errors.hasErrors()) {

            LinkedList<LinkedHashMap<String, String>> errorList = common.refineErrors(errors);
            log.warn("COMPANY 회원가입 예외 : " + errorList.toString()); //FE 필터 거치지 않았으므로 WARN으로 기록

            mav.setViewName("register/company");
            mav.addObject("errors", errorList);

            return mav;
        }


        Company companyEntity = companyDTO.toEntity();
        companyEntity.verification("BRONZE", 0L, 0L, State.NORMAL); //TODO : 가입 승인 페이지 생길 때 까지..
        accountService.createAccount(companyEntity);
        mav.setViewName("login/logIn");

        return mav;
    }

    @GetMapping("/register/success")
    public String success() {
        return "register/success";
    }

    @GetMapping("officer/family-company/screen")
    public ModelAndView companyRegistrationScreen(ModelAndView mav) {

        mav.addObject("companyDtos", accountService.getAllPendingCompanies());
        mav.setViewName("officer/family-company/register");

        return mav;
    }

    @GetMapping("/officer/family-company/screen/detail/{accountId}")
    public ModelAndView registrationDetail(ModelAndView mav, @PathVariable Long accountId, Errors error){

        Account account = accountService.getPendingAccountById(accountId);

        mav.addObject("account", account);

        mav.setViewName("officer/family-company/screen/detail");

        return mav;
    }

    @PostMapping("officer/family-company/screen/detail/{accountId}/accept")
    public ModelAndView registrationAccept(ModelAndView mav, @PathVariable Long accountId, Errors error){

        accountService.registrationAccept(accountId);

        mav.setViewName("redirect:/officer/family-company/screen");
        return mav;
    }
    @PostMapping("officer/family-company/screen/detail/{accountId}/reject")
    public ModelAndView registrationReject(ModelAndView mav, @PathVariable Long accountId, Errors error){

        accountService.registrationReject(accountId);

        mav.setViewName("redirect:/officer/family-company/screen");
        return mav;
    }




    @GetMapping(path = {"officer/mypage", "company/mypage", "professor/mypage"})
    public ModelAndView mypage(HttpServletRequest req, ModelAndView mav){

        Account account = ((AccountContext)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAccount();

        mav.addObject("account", account.toInformationDTO());
        mav.addObject("accountDTO", common.getAccount());
        mav.addObject("key", 1);
        mav.addObject("page", 1);
        mav.addObject("maxPage", 5);
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

    @GetMapping("accounts/search")
    public String accountSearch(@RequestParam String[] dtypes, @RequestParam String idTag, @RequestParam String nameTag, Model model) {
        model.addAttribute("dtypes", dtypes);
        model.addAttribute("idTag", idTag);
        model.addAttribute("nameTag", nameTag);
        return "account/account-search";
    }

    @GetMapping("accounts/search-result")
    public String accountSearchResult(@RequestParam String key, @RequestParam String dtype, Model model) {

        List<AccountSearchDTO> list = new ArrayList<>();
        if (dtype.equals("S")) {
            list = accountService.findStudentContainName(key);
        } else if (dtype.equals("P")) {
            list = accountService.findProfessorContainName(key);
        } else if (dtype.equals("C")) {
            list = accountService.findCompanyContainName(key);
        }
        model.addAttribute("accountDtos", list);

        return "account/account-search :: account-search-result";
    }
}

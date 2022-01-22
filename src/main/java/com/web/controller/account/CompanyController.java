package com.web.controller.account;

import com.common.Common;
import com.domain.account.Company;
import com.security.service.AccountContext;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.CompanyInformationDTO;
import com.web.dto.account.OfficerInformationDTO;
import com.web.dto.account.ProfessorInformationDTO;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@AllArgsConstructor
@Slf4j
@Controller
public class CompanyController {

    private final AccountService accountService;

    private final Common common;

    @PostMapping("company/mypage/update")
    public ModelAndView updateInformation(@Validated @ModelAttribute CompanyInformationDTO accInfDto, Errors errors, ModelAndView mav, HttpServletRequest req){

        if(errors.hasErrors()) {    // Validation 통과 못할 시
            LinkedList<LinkedHashMap<String, String>> errorList = common.refineErrors(errors);
            mav.addObject("errors", errorList);
            mav.setViewName("redirect:/error");
            return mav;
        }

        accountService.updateAccountInformation(req, accInfDto, mav);

        return mav;
    }


}

package com.web.controller.account;

import com.common.Common;
import com.web.dto.account.CompanyInformationDTO;
import com.web.service.AccountService;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@AllArgsConstructor
@Slf4j
@Controller
public class CompanyController {

    private final AccountService accountService;

    private final AnnualFeeService annualFeeService;
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

    @GetMapping("company/mypage/currentized")
    public ModelAndView currentized(ModelAndView mav){
        Boolean infoUpdate = common.getAccount().getModifiedDate().isAfter(LocalDateTime.of(LocalDateTime.now().getYear(), 1, 1, 0,0,0));
        mav.addObject("infoUpdate", infoUpdate); // 기업 정보

        mav.addObject("annualFee", annualFeeService.currentizedCheck()); // 연회비 갱신

        mav.addObject("saleUpdate", false); // 매출 갱신

        mav.setViewName("company/mypage/currentized");
        return mav;
    }

}

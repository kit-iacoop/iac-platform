package com.web.controller.annualfee;


import com.domain.account.Company;
import com.security.service.AccountContext;
import com.web.dto.AnnualFeeHistoryDTO;
import com.web.dto.account.CompanyInformationDTO;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Controller
public class AnnualFeeController {

    @Autowired
    AnnualFeeService annualFeeService;

    @GetMapping("/company/annual-fee/payment-application")
    public ModelAndView paymentApplication(ModelAndView mav){


        return mav;
    }

    @GetMapping("/officer/annual-fee/payment-screening")
    public ModelAndView paymentScreening(ModelAndView mav){


        return mav;
    }

    @GetMapping(path = { "/company/annual-fee/history"})
    public ModelAndView paymentHistory(ModelAndView mav){

        log.warn("/company/annual-fee/history");

        AccountContext ac = (AccountContext)(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        Long companyId = ((Company)ac.getAccount()).getAccountId();

        List<AnnualFeeHistoryDTO> dtos = annualFeeService.findAllHistoryDtoByCompanyId(companyId);

        log.warn("findAllHistoryDtoByCompanyId()");
        mav.addObject("annualFeeRequestDTO", dtos);

        System.out.println(dtos.size());
        System.out.println(dtos);


        mav.setViewName("company/annual-fee/history");

        return mav;
    }




}

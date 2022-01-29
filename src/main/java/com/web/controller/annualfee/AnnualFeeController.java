package com.web.controller.annualfee;


import com.domain.account.Company;
import com.security.service.AccountContext;
import com.web.dto.annualfee.AnnualFeeHistoryDTO;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.QueryOptionDTO;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

        mav.setViewName("company/annual-fee/payment");

        return mav;
    }

    @PostMapping("/officer/annual-fee/payment-screening/accept")
    public String acceptPayment(@RequestParam(value="checkList[]") List<Long> checkList){

        System.out.println(checkList);
        annualFeeService.acceptPayments(checkList);

        return "redirect:/officer/annual-fee/payment-screening";
    }

    @PostMapping("/officer/annual-fee/payment-screening/reject")
    public String rejectPayment(@RequestParam(value="checkList[]") List<Long> checkList){

        System.out.println(checkList);
        annualFeeService.rejectPayments(checkList);

        return "redirect:/officer/annual-fee/payment-screening";
    }



    @GetMapping("/officer/annual-fee/payment-screening")
    public ModelAndView paymentScreening(ModelAndView mav, @ModelAttribute @Validated QueryOptionDTO queryOptionDTO){



        List<AnnualFeeInfoDTO> infoDTOs = annualFeeService.findInfoDtoListWithQDsl(queryOptionDTO);
//        List<AnnualFeeInfoDTO> infoDTOs = annualFeeService.findAllInfoDto();
//        infoDTOs = annualFeeService.findAllInfoDto();



        mav.setViewName("officer/family-company-accept/annual-fee-screen");
        mav.addObject("annualFeeDTOs", infoDTOs);

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

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTimmerEditor);
    }

}

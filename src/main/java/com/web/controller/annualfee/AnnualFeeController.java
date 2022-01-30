package com.web.controller.annualfee;


import com.common.Common;
import com.domain.account.Company;
import com.domain.gradePolicy.GradePolicy;
import com.security.service.AccountContext;
import com.web.dto.annualfee.AnnualFeeHistoryDTO;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.QueryOptionDTO;
import com.web.service.AnnualFeeService;
import com.web.service.GradePolicyService;
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
    private Common common;

    @Autowired
    private AnnualFeeService annualFeeService;

    @Autowired
    private GradePolicyService gradePolicyService;

    @GetMapping("/company/annual-fee/payment-application")
    public ModelAndView paymentApplication(ModelAndView mav){

        mav.addObject("accountDTO", common.getAccount());

        List<GradePolicy> gp = gradePolicyService.findAll();
        mav.addObject("gradePolicyDTOS", gp);


        mav.setViewName("company/annual-fee/payment");

        return mav;
    }


    @PostMapping("/company/annual-fee/payment-application")
    public ModelAndView paymentApplicationPost(ModelAndView mav, @RequestParam("gradePolicyId") Long gradePolicyId,
                                               @RequestParam("point") Long point, @RequestParam("cash") Long cash){

        annualFeeService.requestPayment(gradePolicyId, point, cash);

        mav.setViewName("company/annual-fee/payment-success");

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

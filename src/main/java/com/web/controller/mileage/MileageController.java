package com.web.controller.mileage;



import com.common.Common;

import com.web.dto.mileage.QueryOptionDTO;
import com.web.dto.mileage.MileageHistoryDTO;
import com.web.service.CompanyMileageService;
import com.web.service.MileageFileService;
import com.web.service.MileagePolicyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Controller
public class MileageController {

    private final Common common;
//    private final MileageFileService mileageFileService;
    private final CompanyMileageService companyMileageService;
//    private final MileagePolicyService mileagePolicyService;


    @GetMapping("/company/mileage/history")
    public ModelAndView mileageHistory(ModelAndView mav, @ModelAttribute @Validated QueryOptionDTO queryOptionDTO){

        List<MileageHistoryDTO> dtos = companyMileageService.findAllHistoryDTOByCompanyIdAndDOption(common.getAccountContext().getAccount().getAccountId(), queryOptionDTO);

        mav.addObject("mileageHistoryDTOs", dtos);
        mav.setViewName("company/industry-cooperation/project/activity-proof");

        return mav;
    }

    @GetMapping("/officer/mileage/screening")
    public ModelAndView mileageScreening(ModelAndView mav, @ModelAttribute @Validated QueryOptionDTO queryOptionDTO){

        List<MileageHistoryDTO> dtos = companyMileageService.findAllHistoryDTOWithDOption(queryOptionDTO);

        mav.addObject("mileageHistoryDTOs", dtos);
        mav.setViewName("officer/project/activity-screen");
        return mav;
    }


    @GetMapping("/officer/mileage/request")
    public ModelAndView requestMileage(ModelAndView mav){


        mav.setViewName("company/industry-cooperation/project/activity-proof-register");
        return mav;
    }




    @PostMapping("/officer/mileage/screening/accept")
    public ModelAndView acceptMileage(ModelAndView mav){


        return mav;
    }

    @PostMapping("/officer/mileage/screening/reject")
    public ModelAndView rejectMileage(ModelAndView mav){


        return mav;
    }




    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTimmerEditor);
    }


}
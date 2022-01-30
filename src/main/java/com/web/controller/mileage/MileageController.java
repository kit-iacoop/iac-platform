package com.web.controller.mileage;



import com.common.Common;
import com.domain.companyMileage.CompanyMileageRepository;
import com.domain.mileageFile.MileageFileRepository;
import com.domain.mileagePolicy.MileagePolicyRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Slf4j
@Controller
public class MileageController {

    private final Common common;
    private final MileageFileRepository mileageFileRepository;
    private final CompanyMileageRepository companyMileageRepository;
    private final MileagePolicyRepository mileagePolicyRepository;


    @GetMapping("/company/mileage/history")
    public ModelAndView mileageHistory(ModelAndView mav){

        companyMileageRepository.findAllHistoryDTOByCompanyId(common.getAccountContext().getAccount().getAccountId());

        mav.addObject("companyMileageDTOs");
        mav.setViewName("company/industry-cooperation/project/activity-proof");

        return mav;
    }

    @GetMapping("/officer/mileage/screening")
    public ModelAndView mileageScreening(ModelAndView mav){


        mav.setViewName("officer/project-accept/activity-screen");
        return mav;
    }



}
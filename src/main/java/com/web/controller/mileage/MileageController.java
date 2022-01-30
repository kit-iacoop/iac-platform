package com.web.controller.mileage;



import com.common.Common;
import com.domain.companyMileage.CompanyMileageRepository;
import com.domain.mileageFile.MileageFileRepository;
import com.domain.mileagePolicy.MileagePolicyRepository;

import com.web.dto.mileage.QueryOptionDTO;
import com.web.dto.mileage.MileageHistoryDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Controller
public class MileageController {

    private final Common common;
    private final MileageFileRepository mileageFileRepository;
    private final CompanyMileageRepository companyMileageRepository;
    private final MileagePolicyRepository mileagePolicyRepository;


    @GetMapping("/company/mileage/history")
    public ModelAndView mileageHistory(ModelAndView mav, @ModelAttribute @Validated QueryOptionDTO queryOptionDTO){

        List<MileageHistoryDTO> dtos = companyMileageRepository.findAllHistoryDTOByCompanyIdAndDOption(common.getAccountContext().getAccount().getAccountId(), queryOptionDTO);

        mav.addObject("mileageHistoryDTOs", dtos);
        mav.setViewName("company/industry-cooperation/project/activity-proof");

        return mav;
    }

    @GetMapping("/officer/mileage/screening")
    public ModelAndView mileageScreening(ModelAndView mav){


        mav.setViewName("officer/project-accept/activity-screen");
        return mav;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTimmerEditor);
    }


}
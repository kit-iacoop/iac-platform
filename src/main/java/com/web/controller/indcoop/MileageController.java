package com.web.controller.annualfee;



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Industry-academic activities.

@AllArgsConstructor
@Slf4j
@Controller
public class MileageController {

    @GetMapping("/company/mileage/history")
    public ModelAndView history(ModelAndView mav){

        mav.setViewName("company/industry-cooperation/project/activity-proof");
        return mav;
    }

    @GetMapping("/company/mileage/request")
    public ModelAndView request(ModelAndView mav){
        mav.setViewName("company/industry-cooperation/project/activity-proof-register");
        return mav;
    }

    @GetMapping("/company/mileage/screening")
    public ModelAndView screening(ModelAndView mav){
        mav.setViewName("officer/project/activity-screen");
        return mav;
    }


}

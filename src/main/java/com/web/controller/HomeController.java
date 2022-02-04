package com.web.controller;

import com.common.Common;
import com.web.dto.CollaboRequestDTO;
import com.web.dto.CopyrightDTO;
import com.web.dto.NoticeBoardDTO;
import com.web.service.BoardService;
import com.web.service.CopyrightService;
import com.web.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Slf4j
@Controller

public class HomeController {

    private final Common common;
    private final RequestService requestService;
    private final BoardService boardService;

    @GetMapping(value="/")
    public String home(Model model) {
        Pageable page = PageRequest.of(0, 4, Sort.by("createdDate").descending());

        Page<CollaboRequestDTO> allRequest = requestService.findRequestByTypeAndKey("open", "", page);
        Page<NoticeBoardDTO> boardPage = boardService.findAllBoard(page, "");

        model.addAttribute("collaboRequestDtos", allRequest);
        model.addAttribute("boardDtos", boardPage);
        return "index";
    }

    // @GetMapping( "/register")
    // public String register() {
    //     return "register/main";
    // }

    @GetMapping(path = {"/company", "/professor", "/officer"})
    public ModelAndView accountHome(ModelAndView mav, HttpServletRequest req) {
        mav.addObject("accountDTO", common.getAccount());
        mav.setViewName(common.getReqUrlPrefix(req) +"/index");
        return mav;
    }

    @GetMapping("/company/menu")
    public String menuForC() {
        return "/company/menu";
    }

    @GetMapping("/officer/menu")
    public String menuForO() {
        return "/officer/menu";
    }

    @GetMapping("/company/industry-cooperation/project/submenu")
    public String submenuForC() {
        return "company/industry-cooperation/project/submenu";
    }

    @GetMapping("/about")
    public String aboutFamily() {
        return "about/about-family";
    }
    
    @GetMapping("/about/mileage")
    public String mileage() {
        return "about/about-mileage";
    }
}

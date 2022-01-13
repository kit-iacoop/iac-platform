package com.web.controller.copyright;


import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
public class CopyrightController {
    private CopyrightService copyrightService;

    @GetMapping("/copyright")
    @ResponseBody
    public ModelAndView findAllCopyright(@PageableDefault() Pageable page, @RequestParam(required = false, value = "key") String key) {
        List<CopyrightDTO> copyright;
        if (key.isEmpty()) {
            copyright = copyrightService.findCopyright(page);
        } else {
            copyright = copyrightService.findCopyrightByKey(page, key);
        }
        return new ModelAndView("copyright/copyright-list").addObject(copyright);
    }
}

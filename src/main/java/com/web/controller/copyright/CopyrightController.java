package com.web.controller.copyright;


import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
public class CopyrightController {
    private CopyrightService copyrightService;

    @GetMapping("/copyright")
    public ModelAndView findAllCopyright() {
        List<CopyrightDTO> copyright = copyrightService.findCopyright();
        // viewName은 임시로 정함
        return new ModelAndView("copyright/find").addObject(copyright);
    }
}

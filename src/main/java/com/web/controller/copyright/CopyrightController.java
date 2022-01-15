package com.web.controller.copyright;


import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CopyrightController {

    private final CopyrightService copyrightService;

    @Autowired
    public CopyrightController(CopyrightService copyrightService) {
        this.copyrightService = copyrightService;
    }

    @GetMapping("/copyright")
    @ResponseBody
    public ModelAndView findAllCopyright(@PageableDefault() Pageable page, @RequestParam(required = false, value = "key") String key) {
        Page<CopyrightDTO> dtoList;
        if (key == null) {
            dtoList = copyrightService.findCopyright(page);
        } else {
            dtoList = copyrightService.findCopyrightByKey(page, key);
        }
        Map<String, Object> models = new HashMap<>();
        models.put("copyrightDtos", dtoList);
        models.put("page", page.getPageNumber());
        models.put("maxPage", dtoList.getTotalPages());
        models.put("key", key);
        return new ModelAndView("copyright/copyright-list").addAllObjects(models);
    }

    @GetMapping("/copyright/{id}")
    public ModelAndView viewCopyrightDetail(@PathVariable String id) {

        CopyrightDTO copyrightDetail = copyrightService.findCopyrightDetail(id);

        Map<String, Object> models = new HashMap<>();
        models.put("detail", copyrightDetail);
        return new ModelAndView("copyright/copyright-detail").addAllObjects(models);
    }
}

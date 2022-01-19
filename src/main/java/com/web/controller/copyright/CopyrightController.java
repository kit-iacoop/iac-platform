package com.web.controller.copyright;

import com.domain.common.CopyrightType;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("copyrights")
public class CopyrightController {

    private final CopyrightService copyrightService;

    @Autowired
    public CopyrightController(CopyrightService copyrightService) {
        this.copyrightService = copyrightService;
    }

    // 모든 Request 에서 공통 Attribute 필요시 사용할것
//    @ModelAttribute
//    public void commonAttribute(Model model) {
//        model.addAttribute("asdf", "");
//
//    }

    @GetMapping({"", "/"})
    public String redirectList() {
        return "redirect:/copyrights/list";
    }

    @GetMapping("/list")
    public String findAllCopyright(@PageableDefault() Pageable page, @RequestParam(required = false, value = "key") String key, Model model) {
        Page<CopyrightDTO> dtoList;
        if (key == null) {
            dtoList = copyrightService.findCopyright(page);
        } else {
            dtoList = copyrightService.findCopyrightByKey(page, key);
        }
        Map<String, Object> models = new HashMap<>();
        models.put("copyrightDtos", dtoList);
        models.put("page", page.getPageNumber() + 1);
        models.put("maxPage", dtoList.getTotalPages());
        models.put("key", key);
        model.addAllAttributes(models);
        return "copyright/copyright-list";
    }

    @GetMapping("/list/{id}")
    public String viewCopyrightDetail(@PathVariable String id, Model model) {

        model.addAttribute("copyrightDto", copyrightService.findCopyrightDetail(id));

        return "copyright/copyright-detail";
    }

    @GetMapping("/new")
    public String newCopyrightForm(Model model) {
        model.addAttribute("copyrightDTO", new CopyrightDTO());     // form th:object에 필요
        model.addAttribute("copyrightTypes", CopyrightType.values());
        return "copyright/copyright-form";
    }

    @PostMapping("/list")
    public String insertNewCopyright(@RequestBody @ModelAttribute @Valid CopyrightDTO copyrightDTO, Model model) {

        return "copyright/";
    }

}
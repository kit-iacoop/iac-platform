package com.web.controller.field;

import com.web.dto.FieldCategoryDTO;
import com.web.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("fields")
@Controller
@RequiredArgsConstructor

public class FieldController {
    private final FieldService fieldService;

    @ResponseBody
    @GetMapping("/{parent}/children")
    public List<FieldCategoryDTO> getChildren(@PathVariable String parent) {
        return fieldService.getChildren(Long.valueOf(parent));
    }
}

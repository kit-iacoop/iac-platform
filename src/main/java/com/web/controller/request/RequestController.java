package com.web.controller.request;


import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("requests")
@Controller
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping({"/"})
    public String redirectList() {

        return "redirect:/requests/list";
    }

    @GetMapping("/list")
    public String requestList(
            @RequestParam(name = "type", defaultValue = "open") String type,
            @RequestParam(name = "key", required = false) String key,
            @PageableDefault Pageable pageable, Model model) {

        if (!type.equals("all") & !type.equals("close") & !type.equals("my") & !type.equals("capstone")) {
            type = "open";
        }
        if (key == null) {
            key = "";
        }

        Page<CollaboRequestDTO> allRequest = requestService.findRequestByTypeAndKey(type, key, pageable);

        model.addAttribute("collaboRequestDtos", allRequest);
        model.addAttribute("type", type);
        model.addAttribute("page", pageable.getPageNumber() + 1);
        model.addAttribute("maxPage", allRequest.getTotalPages());
        model.addAttribute("key", key);
        return "request/request-list";
    }

    @GetMapping("/list/{id}")
    public String requestDetail(@PathVariable String id, Model model) {
        model.addAttribute("requestDto", requestService.getRequestDetail(id));
        return "request/request-detail";
    }

    @GetMapping("/new")
    public String newRequestForm(Model model) {
        model.addAttribute("requestDto", new CollaboRequestDTO());
        return "request/request-form";
    }

    @PostMapping("/list")
    public String insertNewRequest(@RequestBody @ModelAttribute @Valid CollaboRequestDTO collaboRequestDTO, Model model) {
        requestService.insertNewRequest(collaboRequestDTO);


        return "redirect:/requests/list";
    }
}

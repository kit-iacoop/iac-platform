package com.web.controller.request;


import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String requestList(Model model) {

        List<CollaboRequestDTO> allRequest = requestService.findAllRequest();
        model.addAttribute("collaboRequestDtos", allRequest);
        return "request/request-list";
    }

    @GetMapping("/list/{id}")
    public String requestDetail(@PathVariable String id, Model model) {
        model.addAttribute("requestDto", requestService.getRequestDetail(id));
        return "request/request-detail";
    }
}

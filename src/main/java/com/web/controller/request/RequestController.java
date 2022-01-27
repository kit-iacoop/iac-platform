package com.web.controller.request;


import com.common.Common;
import com.domain.account.Account;
import com.domain.security.role.Role;
import com.security.service.AccountContext;
import com.web.dto.CollaboRequestDTO;
import com.web.dto.FieldCategoryDTO;
import com.web.dto.ProjectDTO;
import com.web.service.FieldService;
import com.web.service.ProjectService;
import com.web.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping("requests")
@Controller
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private final ProjectService projectService;
    private final Common common;
    private final FieldService fieldService;

    @GetMapping({"/"})
    public String redirectList() {

        return "redirect:/requests/list";
    }

    @GetMapping("/list")
    public String requestList(
            @RequestParam(name = "type", defaultValue = "open") String type,
            @RequestParam(name = "key", required = false) String key,
            @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        if (!type.equals("all") & !type.equals("close") & !type.equals("my") & !type.equals("capstone")) {
            type = "open";
        }
        if (key == null) {
            key = "";
        }

        Page<CollaboRequestDTO> allRequest = requestService.findRequestByTypeAndKey(type, key, pageable);
        List<FieldCategoryDTO> allCategory = fieldService.getAllCategory();

        model.addAttribute("collaboRequestDtos", allRequest);
        model.addAttribute("categories", allCategory);
        model.addAttribute("type", type);
        model.addAttribute("page", pageable.getPageNumber() + 1);
        model.addAttribute("maxPage", allRequest.getTotalPages());
        model.addAttribute("key", key);
        return "request/collabo";
    }

    @GetMapping("/list/query")
    public String queriedRequestList(
            @RequestParam(name = "type", defaultValue = "") String type, // 공개 비공개
            @RequestParam(name = "term", defaultValue = "") String term, // 전체, 장기, 단기
            @RequestParam(name = "fields[]", defaultValue = "") String[] fields, // 분야 id들 (없으면 all)
            @RequestParam(name = "options[]", defaultValue = "") String[] options, // 캡스톤여부, 융합프로젝트 여부 (없으면 all)
            @RequestParam(name = "key", defaultValue = "") String key, // 검색어
            @PageableDefault(sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<CollaboRequestDTO> queriedList = requestService.findRequestByQuery(type, term, fields, options, key, pageable);

        return "request/collabo :: info-contents";
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

    @PostMapping("/list/{id}/open")
    public String closeToOpen(@PathVariable String id) {

        requestService.closeToOpen(Long.valueOf(id));

        return "redirect:/requests/list/" + id;
    }

    @PostMapping("/list/{id}/join")
    public String requestAttend(@PathVariable String id) {
        AccountContext context = common.getAccountContext();
        Account account = context.getAccount();

        if (context.hasRole("PROFESSOR")) {
            requestService.requestAttend(Long.valueOf(id), account.getAccountId());
            return "redirect:/requests/list/" + id;
        }

        return "redirect:/requests/list";
    }

    @GetMapping("/list/{id}/project")
    public String makeProjectForm(@PathVariable String id, Model model) {
        AccountContext context = common.getAccountContext();

        if (context.hasRole("PROFESSOR")) {
            ProjectDTO projectDTO = projectService.makeProjectFormDTO(Long.valueOf(id));
            model.addAttribute("projectDto", projectDTO);
            return "request/project-form";
        }
        return "redirect:/requests/list/" + id;

    }

    @PostMapping("/list/{id}/project")
    public String makeProject(@PathVariable String id, @RequestBody @ModelAttribute @Valid ProjectDTO projectDTO, Model model) {
        AccountContext context = common.getAccountContext();
        Account account = context.getAccount();

        if (context.hasRole("OFFICER")) {
            Long projectId = projectService.makeProject(projectDTO);
            return "redirect:/projects/list/" + projectId;
        }
        return "redirect:/requests/list/" + id;
    }
}
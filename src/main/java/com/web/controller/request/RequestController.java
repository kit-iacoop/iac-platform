package com.web.controller.request;


import com.common.Common;
import com.domain.account.Account;
import com.domain.security.role.Role;
import com.security.service.AccountContext;
import com.web.dto.CollaboRequestDTO;
import com.web.dto.ProjectDTO;
import com.web.service.ProjectService;
import com.web.service.RequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping("requests")
@Controller
public class RequestController {
    private final RequestService requestService;
    private final ProjectService projectService;

    public RequestController(
            RequestService requestService,
            ProjectService projectService) {

        this.requestService = requestService;
        this.projectService = projectService;
    }

    @GetMapping({"/"})
    public String redirectList() {

        return "redirect:/requests/list";
    }

    @GetMapping("/list")
    public String requestList(
            @RequestParam(name = "type", defaultValue = "open") String type,
            @RequestParam(name = "key", required = false) String key,
            @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        System.out.println("****************************** 기술요청 목록");

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
        System.out.println("********************** 기술요청 상세정보");

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
        System.out.println("******************** 공개로 변경");

        requestService.closeToOpen(Long.valueOf(id));

        return "redirect:/requests/list/" + id;
    }

    @PostMapping("/list/{id}/join")
    public String requestAttend(@PathVariable String id) {
        AccountContext principal = (AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = principal.getAccount();
        Set<Role> accountRoles = account.getAccountRoles();
        for (Role r : accountRoles) {
            if (r.getRoleName().equals("ROLE_PROFESSOR")) {
                System.out.println("************************** 참가요청");
                requestService.requestAttend(Long.valueOf(id), account.getAccountId());
                return "redirect:/requests/list/" + id;
            }
        }
        return "redirect:/requests/list";
    }

    @GetMapping("/list/{id}/project")
    public String makeProjectForm(@PathVariable String id, Model model) {
        AccountContext principal = (AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = principal.getAccount();
        if (account.getAccountRoles().contains(Common.getOfficerRoleInstance())) {
            ProjectDTO projectDTO = projectService.makeProjectFormDTO(Long.valueOf(id));
            model.addAttribute("projectDto", projectDTO);
            return "request/project-form";
        }
        return "redirect:/requests/list/" + id;

    }

    @PostMapping("/list/{id}/project")
    public String makeProject(@PathVariable String id, @RequestBody @ModelAttribute @Valid ProjectDTO projectDTO, Model model) {
        AccountContext principal = (AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = principal.getAccount();
        if (account.getAccountRoles().contains(Common.getOfficerRoleInstance())) {
            Long projectId = projectService.makeProject(projectDTO);
            return "redirect:/projects/list/" + projectId;
        }
        return "redirect:/requests/list/" + id;
    }
}
package com.web.controller.project;


import com.web.dto.ProjectDTO;
import com.web.dto.ProjectSalesHistoryDTO;
import com.web.service.ProjectService;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("projects")
@Controller
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public String projectList(@PageableDefault Pageable pageable, Model model) {
        Page<ProjectDTO> allProject = projectService.findAllProject(pageable);

        return "project/project-list";
    }

    @GetMapping("/list/{id}")
    public String getProjectDetail(@PathVariable String id, Model model) {

        model.addAttribute("projectDto", projectService.getProjectDetail(id));
        return "project/project-detail";
    }

    @PostMapping("/list/{id}/mid-output")
    public String addProjectMidOutput(
            @PathVariable String id,
            @RequestParam(name = "midFiles[]", required = false) List<MultipartFile> fileList,
            @RequestParam(name = "midRemoveFiles[]", required = false) List<String> removeFileIdList) {

        projectService.insertMidOutput(Long.valueOf(id), fileList);

        return "redirect:/projects/list/" + id;
    }

    @PostMapping("/list/{id}/final-output")
    public String addProjectFinalOutput(
            @PathVariable String id,
            @RequestParam(name = "finalFiles[]", required = false) List<MultipartFile> fileList,
            @RequestParam(name = "finalRemoveFiles[]", required = false) List<String> removeFileIdList) {

        projectService.insertFinalOutput(Long.valueOf(id), fileList);

        return "redirect:/projects/list/" + id;
    }

    @GetMapping("/list/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) {

        ResponseEntity<Resource> resourceResponseEntity = projectService.downloadFile(id);

        if (resourceResponseEntity.getStatusCode().is2xxSuccessful()) {
            return resourceResponseEntity;
        }
        return null;
    }

    @GetMapping("/list/{id}/sales")
    public String insertNewSales(@PathVariable String id, @RequestBody @ModelAttribute @Valid ProjectSalesHistoryDTO projectSalesHistoryDTO) {

        System.out.println("projectSalesHistoryDTO.getProjectId() = " + projectSalesHistoryDTO.getProjectId());
        System.out.println("projectSalesHistoryDTO.getYear() = " + projectSalesHistoryDTO.getYear());
        System.out.println("projectSalesHistoryDTO.getSales() = " + projectSalesHistoryDTO.getSales());

        return "redirect:/projects/list/" + id;
    }

    @PostMapping("/sales/{id}/files")
    public String addSalesProofFiles(
            @PathVariable String id,
            @RequestParam(name = "salesFiles[]", required = false) List<MultipartFile> fileList,
            @RequestParam(name = "salesRemoveFiles[]", required = false) List<String> removeFileIdList) {

        System.out.println("id = " + id);
        fileList.forEach(System.out::println);
        System.out.println("==========================================");
        if (removeFileIdList != null)
            removeFileIdList.forEach(System.out::println);

        return "redirect:/";    // project id 가져와서 프로젝트 상세정보 화면으로 리다이렉트
    }

}
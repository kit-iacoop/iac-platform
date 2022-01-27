package com.web.controller.project;


import com.web.dto.ProjectDTO;
import com.web.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

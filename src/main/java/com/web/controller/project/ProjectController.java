package com.web.controller.project;


import com.web.dto.ProjectDTO;
import com.web.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("projects")
@Controller
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public String projectList(Model model) {
        List<ProjectDTO> allProject = projectService.findAllProject();

        return "project/project-list";
    }
}

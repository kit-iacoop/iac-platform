package com.web.service.Impl;

import com.domain.project.Project;
import com.domain.project.ProjectRepository;
import com.web.dto.ProjectDTO;
import com.web.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<ProjectDTO> findAllProject(Pageable pageable) {
        Page<Project> all = projectRepository.findAll(pageable);
        return all.map(ProjectDTO::new);
    }
}

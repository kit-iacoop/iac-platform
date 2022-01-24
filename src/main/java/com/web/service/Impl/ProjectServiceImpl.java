package com.web.service.Impl;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.project.Project;
import com.domain.project.ProjectRepository;
import com.web.dto.ProjectDTO;
import com.web.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final CollaboRequestRepository collaboRequestRepository;
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(
            CollaboRequestRepository collaboRequestRepository,
            ProjectRepository projectRepository) {

        this.collaboRequestRepository = collaboRequestRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<ProjectDTO> findAllProject(Pageable pageable) {
        Page<Project> all = projectRepository.findAll(pageable);
        return all.map(ProjectDTO::new);
    }

    @Override
    public ProjectDTO makeProjectFormDTO(Long id) {
        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(id);
        if (maybeRequest.isPresent()) {
            CollaboRequest request = maybeRequest.get();
            new ProjectDTO(request);
        }
        return null;
    }

    @Override
    public Long makeProject(Long requestId) {

        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(requestId);
        if (maybeRequest.isPresent()) {
            CollaboRequest request = maybeRequest.get();
            Project.builder()
                    .
        }
        return 0L;
    }
}

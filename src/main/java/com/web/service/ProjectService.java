package com.web.service;

import com.web.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Page<ProjectDTO> findAllProject(Pageable pageable);

    ProjectDTO makeProjectFormDTO(Long id);
}

package com.web.service;

import com.web.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService {
    Page<ProjectDTO> findAllProject(Pageable pageable);

    ProjectDTO makeProjectFormDTO(Long id);

    Long makeProject(ProjectDTO projectDTO);

    ProjectDTO getProjectDetail(String id);

    int insertMidOutput(Long projectId, List<MultipartFile> files);

    int insertFinalOutput(Long projectId, List<MultipartFile> files);
}

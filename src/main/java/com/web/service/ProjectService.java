package com.web.service;

import com.web.dto.ProjectDTO;
import com.web.dto.ProjectSalesHistoryDTO;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService {
    Page<ProjectDTO> findAllProject(Pageable pageable);

    ProjectDTO makeProjectFormDTO(Long id);

    Long makeProject(ProjectDTO projectDTO);

    ProjectDTO getProjectDetail(String id);

    int insertMidOutput(Long projectId, List<MultipartFile> files);

    int insertFinalOutput(Long projectId, List<MultipartFile> files);

    ResponseEntity<Resource> downloadFile(String id);

    int insertSales(ProjectSalesHistoryDTO projectSalesHistoryDTO, List<MultipartFile> fileList);
}

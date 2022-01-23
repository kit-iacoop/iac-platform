package com.web.service;

import com.web.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> findAllProject();
}

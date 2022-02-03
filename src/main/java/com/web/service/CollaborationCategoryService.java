package com.web.service;

import com.web.dto.CollaborationCategoryDTO;

import java.util.List;

public interface CollaborationCategoryService {
    List<CollaborationCategoryDTO> findAllDTO();
}

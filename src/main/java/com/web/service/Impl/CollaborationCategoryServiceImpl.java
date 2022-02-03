package com.web.service.Impl;

import com.domain.collaborationCategory.CollaborationCategoryRepository;
import com.web.dto.CollaborationCategoryDTO;
import com.web.service.CollaborationCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CollaborationCategoryServiceImpl implements CollaborationCategoryService {

    private final CollaborationCategoryRepository collaborationCategoryRepository;

    @Override
    public List<CollaborationCategoryDTO> findAllDTO() {
        return collaborationCategoryRepository.findAllDTO();
    }
}

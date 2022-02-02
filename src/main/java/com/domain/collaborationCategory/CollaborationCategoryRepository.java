package com.domain.collaborationCategory;

import com.web.dto.CollaborationCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollaborationCategoryRepository extends JpaRepository<CollaborationCategory, Long> {

    CollaborationCategory findByCollaborationCategoryId(Long id);

    CollaborationCategory findByCollaborationName(String categoryName);

    @Query("select new com.web.dto.CollaborationCategoryDTO(cc.collaborationCategoryId, cc.collaborationName, cc.level, cc.parentCategory.collaborationCategoryId) from CollaborationCategory cc")
    List<CollaborationCategoryDTO> findAllDTO();
}

package com.domain.collaborationCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborationCategoryRepository extends JpaRepository<CollaborationCategory, Long> {

    CollaborationCategory findByCategoryId(Long id);

    CollaborationCategory findByCollaborationName(String categoryName);
}

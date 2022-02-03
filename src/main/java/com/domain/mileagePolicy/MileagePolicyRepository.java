package com.domain.mileagePolicy;

import com.domain.collaborationCategory.CollaborationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileagePolicyRepository extends JpaRepository<MileagePolicy, Long> {

    MileagePolicy findByMileagePolicyId(Long id);

    MileagePolicy findByCollaborationCategory(CollaborationCategory cc);
}

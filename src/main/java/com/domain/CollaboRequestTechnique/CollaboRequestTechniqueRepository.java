package com.domain.CollaboRequestTechnique;

import com.domain.CollaboRequest.CollaboRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestTechniqueRepository extends JpaRepository<CollaboRequestTechnique, Long> {

    List<CollaboRequestTechnique> findByCollaboRequest(CollaboRequest collaboRequestId);
}

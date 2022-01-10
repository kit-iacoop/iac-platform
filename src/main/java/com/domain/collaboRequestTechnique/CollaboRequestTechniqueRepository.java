package com.domain.collaboRequestTechnique;

import com.domain.collaboRequest.CollaboRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestTechniqueRepository extends JpaRepository<CollaboRequestTechnique, Long> {

    List<CollaboRequestTechnique> findByCollaboRequest(CollaboRequest collaboRequestId);
}

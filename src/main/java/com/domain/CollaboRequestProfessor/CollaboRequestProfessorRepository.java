package com.domain.CollaboRequestProfessor;

import com.domain.CollaboRequest.CollaboRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestProfessorRepository extends JpaRepository<CollaboRequestProfessor, Long> {
    List<CollaboRequestProfessor> findByCollaboRequest(CollaboRequest collaboRequestId);
}

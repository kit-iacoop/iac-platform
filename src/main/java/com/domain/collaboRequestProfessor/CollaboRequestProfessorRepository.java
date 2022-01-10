package com.domain.collaboRequestProfessor;

import com.domain.collaboRequest.CollaboRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestProfessorRepository extends JpaRepository<CollaboRequestProfessor, Long> {
    List<CollaboRequestProfessor> findByCollaboRequest(CollaboRequest collaboRequestId);
}

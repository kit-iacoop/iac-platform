package com.domain.SalesHistoryProofFile;

import com.domain.ProjectSalesHistory.ProjectSalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesHistoryProofFileRepository extends JpaRepository<SalesHistoryProofFile, Long> {

    List<SalesHistoryProofFile> findByProjectSalesHistory(ProjectSalesHistory projectSalesHistory);
}

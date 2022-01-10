package com.domain.salesHistoryProofFile;

import com.domain.projectSalesHistory.ProjectSalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesHistoryProofFileRepository extends JpaRepository<SalesHistoryProofFile, Long> {

    List<SalesHistoryProofFile> findByProjectSalesHistory(ProjectSalesHistory projectSalesHistory);
}

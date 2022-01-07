package com.domain.BudgetDetail;

import com.domain.Project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetDetailRepository extends JpaRepository<BudgetDetail, Long> {

    List<BudgetDetail> findByProject(Project projectId);

}

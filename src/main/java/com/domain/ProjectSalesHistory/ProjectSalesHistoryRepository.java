package com.domain.ProjectSalesHistory;

import com.domain.Project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectSalesHistoryRepository extends JpaRepository<ProjectSalesHistory, Long> {

    List<ProjectSalesHistory> findByProject(Project project);
}

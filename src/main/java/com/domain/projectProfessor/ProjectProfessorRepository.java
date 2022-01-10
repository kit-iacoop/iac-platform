package com.domain.projectProfessor;

import com.domain.account.Professor;
import com.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectProfessorRepository extends JpaRepository<ProjectProfessor, Long> {

    List<ProjectProfessor> findByProject(Project project);

    List<ProjectProfessor> findByProfessor(Professor professor);
}

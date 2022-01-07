package com.domain.ProjectProfessor;

import com.domain.Account.Professor;
import com.domain.Project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectProfessorRepository extends JpaRepository<ProjectProfessor, Long> {

    List<ProjectProfessor> findByProject(Project project);

    List<ProjectProfessor> findByProfessor(Professor professor);
}

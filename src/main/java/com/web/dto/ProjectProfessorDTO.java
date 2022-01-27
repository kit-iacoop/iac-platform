package com.web.dto;

import com.domain.projectProfessor.ProjectProfessor;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectProfessorDTO {

    private String projectProfessorId;
    private String projectId;
    private String professorId;
    private String professorName;
    private String professorDept;
    private String professorUniv;

    public ProjectProfessorDTO(ProjectProfessor projectProfessor) {
        this.projectProfessorId = String.valueOf(projectProfessor.getProjectProfessorId());
        this.projectId = String.valueOf(projectProfessor.getProject().getProjectId());
        this.professorId = String.valueOf(projectProfessor.getProfessor().getAccountId());
        this.professorId = projectProfessor.getProfessor().getName();
        this.professorId = projectProfessor.getProfessor().getDepartment();
        this.professorId = projectProfessor.getProfessor().getUniversity().getUniversityName();
    }

}
package com.web.dto;

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
}

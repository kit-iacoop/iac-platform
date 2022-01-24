package com.web.dto;

import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CollaboRequestProfessorDTO {
    private String collaboRequestProfessorId;
    private String collaboRequestId;
    private String professorId;
    private String professorName;
    private String professorDept;
    private String professorUniv;

    public CollaboRequestProfessorDTO(CollaboRequestProfessor collaboRequestProfessor) {
        this.collaboRequestProfessorId = String.valueOf(collaboRequestProfessor.getCollaboRequestProfessorId());
        this.collaboRequestId = String.valueOf(collaboRequestProfessor.getCollaboRequest().getCollaboRequestId());
        this.professorId = String.valueOf(collaboRequestProfessor.getProfessor().getAccountId());
        this.professorName = collaboRequestProfessor.getProfessor().getName();
        this.professorDept = collaboRequestProfessor.getProfessor().getDepartment();
        this.professorUniv = collaboRequestProfessor.getProfessor().getUniversity().getUniversityName();
    }
}

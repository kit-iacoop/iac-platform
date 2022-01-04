package com.domain.ProjectProfessor;

import com.domain.Account.Professor.Professor;
import com.domain.Project.Project;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT_PROFESSOR")
public class ProjectProfessor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_PROFESSOR_ID", nullable = false)
    private Long projectProfessorId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project projectId;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ACCOUNT_ID", nullable = false)
    private Professor professorAccountId;

    public void setProjectId(Project projectId) {
        if (this.projectId != null) {
            this.projectId.getProfessorList().remove(this);
        }
        this.projectId = projectId;
        projectId.getProfessorList().add(this);
    }

    public void setProfessor(Professor professorAccountId) {
        if (this.professorAccountId != null) {
            this.professorAccountId.getProjectProfessorList().remove(this);
        }
        this.professorAccountId = professorAccountId;
        professorAccountId.getProjectProfessorList().add(this);
    }
}

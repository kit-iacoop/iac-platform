package com.domain.projectProfessor;

import com.domain.account.Professor;
import com.domain.project.Project;
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
    private Project project;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ACCOUNT_ID", nullable = false)
    private Professor professor;

    public void setProject(Project projectId) {
        if (this.project != null) {
            this.project.getProfessorList().remove(this);
        }
        this.project = projectId;
        projectId.getProfessorList().add(this);
    }

    public void setProfessor(Professor professorAccountId) {
        if (this.professor != null) {
            this.professor.getProjectList().remove(this);
        }
        this.professor = professorAccountId;
        professorAccountId.getProjectList().add(this);
    }
}

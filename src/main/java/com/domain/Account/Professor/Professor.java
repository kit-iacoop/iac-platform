package com.domain.Account.Professor;

import com.domain.Account.Account;
import com.domain.CollaboRequestProfessor.CollaboRequestProfessor;
import com.domain.ProjectProfessor.ProjectProfessor;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter

@DiscriminatorValue("P")
@Table(name = "PROFESSOR")
@Entity
public class Professor extends Account {

    @Column(name = "UNIVERSITY_ID", nullable = false)
    private Long universityId;

    @Column(name = "OFFICE_LOCATION", nullable = false)
    private String officeLocation;

    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

    @OneToMany(mappedBy = "professorAccountId")
    List<CollaboRequestProfessor> collaboRequestProfessorList = new ArrayList<>();

    @OneToMany(mappedBy = "professorAccountId")
    List<ProjectProfessor> projectProfessorList = new ArrayList<>();
}

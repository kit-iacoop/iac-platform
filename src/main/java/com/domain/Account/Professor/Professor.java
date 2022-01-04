package com.domain.Account.Professor;

import com.domain.Account.Account;
import com.domain.CollaboRequestProfessor.CollaboRequestProfessor;
import com.domain.ProjectProfessor.ProjectProfessor;
import com.domain.CollaboRequestProfessor.CollaboRequestProfessor;
import com.domain.FieldInterest.FieldInterest;
import com.domain.ProjectProfessor.ProjectProfessor;
import com.domain.University.University;
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

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "UNIVERSITY_ID", nullable = false)
   private University university;

    @Column(name = "OFFICE_LOCATION", nullable = false)
    private String officeLocation;

    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

   @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
   private List<ProjectProfessor> projectList;

   @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
   private List<CollaboRequestProfessor> requestProjectList;

   @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
   private List<FieldInterest> interestedFieldList;

}

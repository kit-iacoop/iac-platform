package com.domain.account;

import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.projectProfessor.ProjectProfessor;
import com.domain.fieldInterest.FieldInterest;
import com.domain.university.University;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


   @OneToMany(mappedBy = "mentorProfessor", fetch = FetchType.LAZY)
    private List<Company> menteeCompanyList;

}

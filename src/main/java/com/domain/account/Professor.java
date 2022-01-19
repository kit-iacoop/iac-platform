package com.domain.account;

import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.projectProfessor.ProjectProfessor;
import com.domain.fieldInterest.FieldInterest;
import com.domain.university.University;

import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.OfficerInformationDTO;
import com.web.dto.account.ProfessorInformationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder

@DiscriminatorValue("P")
@Table(name = "PROFESSOR")
@Entity
public class Professor extends Account {

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "UNIVERSITY_ID", nullable = false)
   private University university;

    @Column(name = "OFFICE_LOCATION", nullable = false)
    private String officeLocation;

    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

    @Builder.Default
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<ProjectProfessor> projectList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<CollaboRequestProfessor> requestProjectList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<FieldInterest> interestedFieldList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "mentorProfessor", fetch = FetchType.LAZY)
    private List<Company> menteeCompanyList = new LinkedList<>();

 @Override
 public ProfessorInformationDTO toInformationDTO() {
  return ProfessorInformationDTO.builder()
          .accountId(accountId)
          .loginId(loginId)
          .password(null)
          .name(name)
          .birthDate(birthDate.toString())
          .zipCode(address.getZipCode())
          .city(address.getCity())
          .street(address.getStreet())
          .email(email)
          .telephone(telephone)
          .status(status)
          // 교수 정보
          .university(university.getUniversityName())
          .officeLocation(officeLocation)
          .department(department)
          .build();

 }
}

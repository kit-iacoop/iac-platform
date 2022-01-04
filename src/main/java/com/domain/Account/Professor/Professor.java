package com.domain.Account.Professor;

import com.domain.Account.Account;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

}

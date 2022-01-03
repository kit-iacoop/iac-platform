package com.domain.Profssor;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROFSSOR", schema = "iac_platform-test")
public class Profssor extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ACCOUNT_ID", nullable = false)
   private Long accountId;

   @Column(name = "UNIVERSITY_ID", nullable = false)
   private Long universityId;

   @Column(name = "OFFICE_LOCATION", nullable = false)
   private String officeLocation;

   @Column(name = "DEPARTMENT", nullable = false)
   private String department;


}

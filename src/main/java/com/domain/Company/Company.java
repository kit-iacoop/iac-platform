package com.domain.Company;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COMPANY", schema = "iac_platform-test")
public class Company extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ACCOUNT_ID", nullable = false)
   private Long accountId;

   @Column(name = "EMPLOYEE_NUMBER", nullable = false)
   private Long employeeNumber;

   @Column(name = "SECTOR", nullable = false)
   private String sector;

   @Column(name = "OWNER", nullable = false)
   private String owner;

   @Column(name = "GRADE", nullable = false)
   private String grade;

   @Column(name = "MILEAGE", nullable = false)
   private Long mileage;

   @Column(name = "POINT", nullable = false)
   private Long point;

   @Column(name = "IS_CURRENTIZED", nullable = false)
   private Long isCurrentized;


}

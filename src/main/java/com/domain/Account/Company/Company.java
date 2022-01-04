package com.domain.Account.Company;

import com.domain.Account.Account;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter

@DiscriminatorValue("C")
@Table(name = "COMPANY")
@Entity
public class Company extends Account {

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

   @Column(name = "CURRENTIZATION_STATUS", nullable = false)
   private Long currentizationStatus;


}

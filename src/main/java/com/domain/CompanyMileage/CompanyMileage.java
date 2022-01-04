package com.domain.CompanyMileage;

import com.domain.Account.Company.Company;
import com.domain.MileageRequest.MileageRequest;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COMPANY_MILEAGE")
public class CompanyMileage extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "COMPANY_MILEAGE_ID", nullable = false, unique = true)
   private Long companyMileageId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Company company;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MILEAGE_REQUEST_ID", nullable = false)
   private MileageRequest mileageRequest;

   @Column(name = "MILEAGE", nullable = false)
   private Long mileage;

   @Column(name = "POINT", nullable = false)
   private Long point;

}

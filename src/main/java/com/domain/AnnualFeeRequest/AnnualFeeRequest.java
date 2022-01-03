package com.domain.AnnualFeeRequest;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ANNUAL_FEE_REQUEST", schema = "iac_platform-test")
public class AnnualFeeRequest extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ANNUAL_FEE_REQUEST_ID", nullable = false)
   private Long annualFeeRequestId;

   @Column(name = "OFFICER_ACCOUNT_ID", nullable = false)
   private Long officerAccountId;

   @Column(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Long companyAccountId;

   @Column(name = "GRADE_POLICY_ID", nullable = false)
   private Long gradePolicyId;

   @Column(name = "YEAR", nullable = false)
   private Long year;

   @Column(name = "CASH", nullable = false)
   private Long cash;

   @Column(name = "POINT", nullable = false)
   private Long point;

   @Column(name = "STATUS", nullable = false)
   private String status;

   @Column(name = "CONFIRM_DATE", nullable = false)
   private java.time.LocalDate confirmDate;


}

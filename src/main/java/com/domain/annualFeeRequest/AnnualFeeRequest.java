package com.domain.annualFeeRequest;

import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.gradePolicy.GradePolicy;
import com.domain.common.BaseTimeEntity;

import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "ANNUAL_FEE_REQUEST")
public class AnnualFeeRequest extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ANNUAL_FEE_REQUEST_ID", nullable = false, unique = true)
   private Long annualFeeRequestId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OFFICER_ACCOUNT_ID", nullable = false)
   private Officer officer;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Company company;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "GRADE_POLICY_ID", nullable = false)
   private GradePolicy gradePolicy;

   @Column(name = "YEAR", nullable = false)
   private Long year;

   @Column(name = "CASH", nullable = false)
   private Long cash;

   @Column(name = "POINT", nullable = false)
   private Long point;

   @Column(name = "PAYMENT_STATUS", nullable = false)
   private State paymentStatus;

   @Column(name = "CONFIRM_DATE", nullable = false)
   private LocalDate confirmDate;


}

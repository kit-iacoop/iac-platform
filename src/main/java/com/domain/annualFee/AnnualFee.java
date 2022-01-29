package com.domain.annualFee;

import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.gradePolicy.GradePolicy;
import com.domain.common.BaseTimeEntity;

import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ANNUAL_FEE")
public class AnnualFee extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ANNUAL_FEE_ID", nullable = false, unique = true)
   private Long annualFeeId;

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
   private Integer year;

   @Column(name = "CASH", nullable = false)
   private Long cash;

   @Column(name = "POINT", nullable = false)
   private Long point;

   @Enumerated(EnumType.STRING)
   @Column(name = "PAYMENT_STATUS", nullable = false)
   private State paymentStatus;

   @Column(name = "CONFIRM_DATE", nullable = true)
   private LocalDate confirmDate;


   // 정상처리 true 반환
   // 비정상처리 false 반환
   public Boolean accept(){

      if(paymentStatus != State.PENDING) { // pending 상태가 아니라면 비정상 경우
         return false;
      }

      company.renewGrade(gradePolicy.getGrade());

      paymentStatus = State.APPROVED;
      confirmDate = LocalDate.now();

      return true;

   }

   // 정상처리 true 반환
   // 비정상처리 false 반환
   public Boolean reject(){

      if(paymentStatus != State.PENDING) { // pending 상태가 아니라면 비정상 경우
         return false;
      }

      paymentStatus = State.REJECTED;

      return true;
   }
}

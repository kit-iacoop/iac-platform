package com.domain.Project;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT", schema = "iac_platform-test")
public class Project extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "PROJECT_ID", nullable = false)
   private Long projectId;

   @Column(name = "COLLABO_REQUEST_ID", nullable = false)
   private Long collaboRequestId;

   @Column(name = "BUDGET_DETAIL_ID", nullable = false)
   private Long budgetDetailId;

   @Column(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Long companyAccountId;

   @Column(name = "START_DATE", nullable = false)
   private Long startDate;

   @Column(name = "END_DATE", nullable = false)
   private Long endDate;


}

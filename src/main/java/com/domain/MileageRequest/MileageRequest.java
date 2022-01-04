package com.domain.MileageRequest;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MILEAGE_REQUEST")
public class MileageRequest extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_REQUEST_ID", nullable = false, unique = true)
   private Long mileageRequestId;

   @Column(name = "OFFICER_ACCOUNT_ID", nullable = false)
   private Long officerAccountId;

   @Column(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Long companyAccountId;

   @Column(name = "MILEAGE_POLICY_ID", nullable = false)
   private Long mileagePolicyId;

   @Column(name = "ACHIEVEMENT_CNT", nullable = false)
   private Long achievementCnt;

   @Column(name = "STATUS", nullable = false)
   private Long status;

   @Column(name = "START_DATE", nullable = false)
   private LocalDate startDate;

   @Column(name = "END_DATE", nullable = false)
   private LocalDate endDate;

}

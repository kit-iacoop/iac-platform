package com.domain.MileagePolicy;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MILEAGE_POLICY", schema = "iac_platform-test")
public class MileagePolicy extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_POLICY_ID", nullable = false)
   private Long mileagePolicyId;

   @Column(name = "COLLABORATION_CATEGORY_ID", nullable = false)
   private Long collaborationCategoryId;

   @Column(name = "MILEAGE", nullable = false)
   private Long mileage;

   @Column(name = "POINT", nullable = false)
   private Long point;

   @Column(name = "IN_OR_OUT", nullable = false)
   private Long inOrOut;


}

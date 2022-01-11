package com.domain.gradePolicy;

import com.domain.annualFeeRequest.AnnualFeeRequest;
import com.domain.common.BaseTimeEntity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GRADE_POLICY")
public class GradePolicy extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "GRADE_POLICY_ID", nullable = false, unique = true)
   private Long gradePolicyId;

   @Column(name = "GRADE", nullable = false)
   private String grade;

   @Column(name = "PRICE", nullable = false)
   private Long price;

   @OneToMany(mappedBy = "gradePolicy",fetch = FetchType.LAZY)
   private List<AnnualFeeRequest> annualFeeRequest;

}
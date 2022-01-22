package com.domain.gradePolicy;

import com.domain.annualFee.AnnualFee;
import com.domain.common.BaseTimeEntity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name = "GRADE_POLICY")
public class GradePolicy extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "GRADE_POLICY_ID", nullable = false, unique = true)
   private Long gradePolicyId;

   @Column(name = "GRADE", nullable = false, unique = true)
   private String grade;

   @Column(name = "PRICE", nullable = false)
   private Long price;

   @OneToMany(mappedBy = "gradePolicy",fetch = FetchType.LAZY)
   private List<AnnualFee> annualFee;

}

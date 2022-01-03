package com.domain.GradePolicy;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "GRADE_POLICY", schema = "iac_platform-test")
public class GradePolicy extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "GRADE_POLICY_ID", nullable = false)
   private Long gradePolicyId;

   @Column(name = "GRADE", nullable = false)
   private String grade;

   @Column(name = "PRICE", nullable = false)
   private Long price;


}

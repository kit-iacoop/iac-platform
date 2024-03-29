package com.domain.mileagePolicy;

import com.domain.collaborationCategory.CollaborationCategory;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name = "MILEAGE_POLICY")
public class MileagePolicy extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_POLICY_ID", nullable = false, unique = true)
   private Long mileagePolicyId;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "COLLABORATION_CATEGORY_ID", nullable = false, unique = true)
   private CollaborationCategory collaborationCategory;

   @Column(name = "MILEAGE", nullable = false)
   private Long mileage;

   @Column(name = "POINT", nullable = false)
   private Long point;

   // @Column(name = "IN_OR_OUT", nullable = true)
   // private String inOrOut;


}

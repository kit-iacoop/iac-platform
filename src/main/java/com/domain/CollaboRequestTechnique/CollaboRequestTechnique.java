package com.domain.CollaboRequestTechnique;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABO_REQUEST_TECHNIQUE", schema = "iac_platform-test")
public class CollaboRequestTechnique extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "COLLABO_REQUEST_TECHNIQUE_ID", nullable = false)
   private Long collaboRequestTechniqueId;

   @Column(name = "FIELD_CATEGORY_ID", nullable = false)
   private Long fieldCategoryId;

   @Column(name = "COLLABO_REQUEST_ID", nullable = false)
   private Long collaboRequestId;


}

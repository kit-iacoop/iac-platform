package com.domain.CollaborationCategory;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABORATION_CATEGORY", schema = "iac_platform-test")
public class CollaborationCategory extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "COLLABORATION_CATEGORY_ID", nullable = false)
   private Long collaborationCategoryId;

   @Column(name = "PARENT_CATEGORY_ID", nullable = false)
   private Long parentCategoryId;

   @Column(name = "COLLABORATION_NAME", nullable = false)
   private String collaborationName;

   @Column(name = "LEVEL", nullable = false)
   private Long level;


}

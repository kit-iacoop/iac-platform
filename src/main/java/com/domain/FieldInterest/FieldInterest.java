package com.domain.FieldInterest;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "FIELD_INTEREST", schema = "iac_platform-test")
public class FieldInterest extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "FIELD_INTEREST_ID", nullable = false)
   private Long fieldInterestId;

   @Column(name = "ACCOUNT_ID", nullable = false)
   private Long accountId;

   @Column(name = "FIELD_CATEGORY_ID", nullable = false)
   private Long fieldCategoryId;


}

package com.domain.Item;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ITEM", schema = "iac_platform-test")
public class Item extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ITEM_ID", nullable = false)
   private Long itemId;

   @Column(name = "COMPANY_ID", nullable = false)
   private Long companyId;

   @Column(name = "ITEM_NAME", nullable = false)
   private String itemName;


}

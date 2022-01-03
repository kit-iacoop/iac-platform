package com.domain.Officer;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "OFFICER", schema = "iac_platform-test")
public class Officer extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ACCOUNT_ID", nullable = false)
   private Long accountId;

   @Column(name = "UNIVERSITY_ID", nullable = false)
   private Long universityId;

   @Column(name = "OFFICE_LOCATION", nullable = false)
   private String officeLocation;


}

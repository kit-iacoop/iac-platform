package com.domain.University;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "UNIVERSITY", schema = "iac_platform-test")
public class University extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "UNIVERSITY_ID", nullable = false)
   private Long universityId;

   @Column(name = "UNIVERSITY_NAME", nullable = false)
   private String universityName;

   @Column(name = "CITY", nullable = false)
   private String city;

   @Column(name = "STREET", nullable = false)
   private String street;

   @Column(name = "ZIPCODE", nullable = false)
   private Long zipcode;


}

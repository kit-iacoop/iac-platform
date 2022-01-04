package com.domain.University;

import com.domain.common.Address;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "UNIVERSITY", schema = "iac_platform-test")
public class University extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "UNIVERSITY_ID", nullable = false, unique = true)
   private Long universityId;

   @Column(name = "UNIVERSITY_NAME", nullable = false, unique = true)
   private String universityName;

   @Embedded
   private Address address;

}

package com.domain.Account;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ACCOUNT", schema = "iac_platform-test")
public class Account extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ACCOUNT_ID", nullable = false)
   private Long accountId;

   @Column(name = "NAME", nullable = false)
   private String name;

   @Column(name = "BIRTH_DATE", nullable = false)
   private java.time.LocalDate birthDate;

   @Column(name = "CITY", nullable = false)
   private String city;

   @Column(name = "STREET", nullable = false)
   private String street;

   @Column(name = "ZIPCODE", nullable = false)
   private Long zipcode;

   @Column(name = "LOGIN_ID", nullable = false)
   private String loginId;

   @Column(name = "PASSWORD", nullable = false)
   private String password;

   @Column(name = "EMAIL", nullable = false)
   private String email;

   @Column(name = "STATUS", nullable = false)
   private String status;

   @Column(name = "DTYPE", nullable = false)
   private Long dtype;


}

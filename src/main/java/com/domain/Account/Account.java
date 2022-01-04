package com.domain.Account;

import com.domain.common.Address;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Getter

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.TABLE) // <union-subclass> 매핑에서 IDENTITY 전략 사용 불가능 한 것으로 보여 불가피하게 TABLE 전략 사용
   @Column(name = "ACCOUNT_ID", nullable = false, unique = true)
   private Long accountId;

   @Column(name = "NAME", nullable = false)
   private String name;

   @Column(name = "BIRTH_DATE", nullable = false)
   private LocalDate birthDate;

   @Embedded
   private Address address;

   @Column(name = "LOGIN_ID", nullable = false, unique = true)
   private String loginId;

   @Column(name = "PASSWORD", nullable = false)
   private String password;

   @Column(name = "EMAIL", nullable = false, unique = true)
   private String email;

   @Column(name = "STATUS", nullable = false)
   private String status;

}

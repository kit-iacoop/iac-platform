package com.domain.account;

import com.domain.copyright.Copyright;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.common.Address;
import com.domain.common.BaseTimeEntity;
import com.domain.security.role.Role;
import com.domain.common.State;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.AccountRolesDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter

@SuperBuilder
@ToString(exclude = {"copyrightList", "meetingAttendantList", "accountRoles"})
@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.TABLE) // <union-subclass> 매핑에서 IDENTITY 전략 사용 불가능 한 것으로 보여 불가피하게 TABLE 전략 사용
   @Column(name = "ACCOUNT_ID", nullable = false, unique = true)
   protected Long accountId;

   @Column(name = "NAME", nullable = false)
   protected String name;

   @Column(name = "BIRTH_DATE", nullable = false)
   protected LocalDate birthDate;

   @Embedded
   protected Address address;

   @Column(name = "LOGIN_ID", nullable = false, unique = true)
   protected String loginId;

   @Column(name = "PASSWORD", nullable = false)
   protected String password;

   @Column(name = "EMAIL", nullable = false)
   protected String email;

   @Column(name = "TELEPHONE", nullable = true)
   protected String telephone;

   @Enumerated(EnumType.STRING)
   @Column(name = "STATUS", nullable = false)
   protected State status;


   @Builder.Default
   @OneToMany(mappedBy = "accountId")
   protected List<Copyright> copyrightList = new LinkedList<>();

   @Builder.Default
   @OneToMany(mappedBy = "account")
   protected List<MeetingAttendant> meetingAttendantList = new LinkedList<>();


   @Builder.Default
   @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
   @JoinTable(name = "account_roles", joinColumns = { @JoinColumn(name = "account_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
   protected Set<Role> accountRoles = new HashSet<>();

   public abstract AccountInformationDTO toInformationDTO();

   public AccountRolesDTO toAccountRolesDto(){
      return AccountRolesDTO.builder()
              .id(accountId.toString())
              .loginId(loginId)
              .email(email)
              .roles(accountRoles.stream()
                      .map(Role::getRoleName)
                      .collect(Collectors.toList()))
              .build();
   }

   public void changePassword(String newPassword){
      this.password = newPassword;
   }

   public void deletePassword(){
      this.password = null;
   }

   public void updateRoles(Set<Role> roleSet){
      this.accountRoles = roleSet;
   }

   public void addRole(Role role){

      if(accountRoles.contains(role)){
         return;
      }

      accountRoles.add(role);
      role.getAccounts().add(this);

   }

   public void removeRole(Role role){
      if(!accountRoles.contains(role)) {
         return;
      }
      accountRoles.remove(role);
      role.getAccounts().remove(this);
   }

}

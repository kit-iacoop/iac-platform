package com.domain.Account.Officer;

import com.domain.Account.Account;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter

@DiscriminatorValue("O")
@Table(name = "OFFICER")
@Entity
public class Officer extends Account {

   @Column(name = "UNIVERSITY_ID", nullable = false)
   private Long universityId;

   @Column(name = "OFFICE_LOCATION", nullable = false)
   private String officeLocation;

}

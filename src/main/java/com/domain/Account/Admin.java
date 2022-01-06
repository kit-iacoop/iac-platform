package com.domain.Account;

import com.domain.Account.Account;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter

@DiscriminatorValue("A")
@Table(name = "ADMIN")
@Entity
public class Admin extends Account {

}

package com.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter

@DiscriminatorValue("A")
@Table(name = "ADMIN")
@Entity
public class Admin extends Account {

}

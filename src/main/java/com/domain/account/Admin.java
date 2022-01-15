package com.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@SuperBuilder
@DiscriminatorValue("A")
@Table(name = "ADMIN")
@Entity
public class Admin extends Account {

}

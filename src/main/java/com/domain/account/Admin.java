package com.domain.account;

import com.web.dto.account.AccountInformationDTO;
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

    @Override
    public AccountInformationDTO toInformationDTO() {
        return null;
    }

    @Override
    public Account updateInformation(AccountInformationDTO accInfDto) {
        return null;
    }
}

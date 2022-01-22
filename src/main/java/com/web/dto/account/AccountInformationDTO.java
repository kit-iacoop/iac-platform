package com.web.dto.account;

import com.domain.account.Account;
import com.domain.account.Company;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

@SuperBuilder
public abstract class AccountInformationDTO {

    protected Long accountId;

//    @Size(min=4, max=20)
//    @NotBlank
    protected String loginId;

//    @Size(min=8, max=20)
//    @NotBlank
    protected String password;

//    @Size(min=1, max=50)
//    @NotEmpty
    protected String name;

    protected String birthDate;

//    @Size(min=5, max=5)
//    @NotBlank
    protected Long zipCode;

//    @Size(min=2, max=30)
//    @NotEmpty
    protected String city;

//    @Size(min=2, max=200)
    protected String street;

//    @Size(min=5, max=200)
//    @NotBlank
//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$")
    protected String email;

//    @Size(min=8, max=15)
//    @NotBlank
    protected String telephone;

    protected State status;

    abstract public Account toEntity();
}

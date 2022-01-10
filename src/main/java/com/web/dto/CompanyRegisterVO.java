package com.web.dto;

import com.domain.common.Address;
import com.domain.common.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Getter
@Setter
public class CompanyRegisterVO {

    private String loginId;
    private String password;

    private String name;
    private Long businessRegistrationNumber;

    private String birthDate;

    private Long zipCode;
    public String city;
    public String street;

    private String email;
    private String telephone;

    private Long employeeNumber;
    private String companyType;
    private String sector;
    private String owner;

    private String subscriptionDate;

}

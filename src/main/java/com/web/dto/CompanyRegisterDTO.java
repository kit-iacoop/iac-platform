package com.web.dto;

import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString

public class CompanyRegisterDTO {

    private String loginId;
    private String password;

    private String name;
    private String businessRegistrationNumber;

    private String birthDate;

    private String zipCode;
    public String city;
    public String street;

    private String email;
    private String telephone;

    private String employeeNumber;
    private String companyType;
    private String sector;
    private String owner;

    private String subscriptionDate;

    public Company toEntity(){
        return Company.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .businessRegistrationNumber(Long.parseLong(businessRegistrationNumber))
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(
                        Address.builder()
                                .city(city)
                                .street(street)
                                .zipCode(Long.parseLong(zipCode))
                                .build()
                                )
                .email(email)
                .telephone(telephone)
                .companyType(companyType)
                .sector(sector)
                .owner(owner)
                .subscriptionDate(LocalDate.parse(subscriptionDate, DateTimeFormatter.ISO_DATE))
                .status(State.PENDING)
                .currentizationStatus(State.NORMAL)
                .build()
                ;
    }
}


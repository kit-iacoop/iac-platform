package com.web.dto;

import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString

public class CompanyRegisterDTO {


    @Size(min=4, max=20)
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String loginId;

    @Size(min=8, max=20)
    @NotBlank(message = "패스워드는 필수 입력 값입니다.")
    private String password;

    @Size(min=1, max=50)
    @NotEmpty(message = "회사명은 필수 입력 값입니다.")
    private String name;

    @Size(min=1, max=50)
    @Positive
    @NotBlank (message = "사업자 등록 번호는 필수 입력 값입니다.")
    private String businessRegistrationNumber;

    private String birthDate;

    @Size(min=5, max=5)
    @NotBlank(message = "우편번호는 필수 입력 값입니다.")
    private String zipCode;

    @Size(min=2, max=30)
    @NotEmpty(message = "도시명은  필수 입력 값입니다.")
    public String city;

    @Size(min=2, max=200)
    public String street;

    @Size(min=5, max=200)
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Size(min=8, max=15)
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String telephone;

    @Size(min=1, max=7)
    @Positive
    private String employeeNumber;

    @Size(min=2, max=10)
    @NotEmpty(message = "회사 구분은 필수 입력 값입니다.")
    private String companyType;

    @Size(min=2, max=100)
    @NotEmpty(message = "회사 분야는 필수 입력 값입니다.")
    private String sector;

    @Size(min=1, max=100)
    private String owner;

    @NotEmpty(message = "협약일은 필수 입력 값입니다.")
    private String subscriptionDate;

    public Company toEntity(){
        return Company.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .businessRegistrationNumber(Long.parseLong(businessRegistrationNumber))
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(new Address(city, street, Long.parseLong(zipCode)))
                .email(email)
                .telephone(telephone)
                .companyType(companyType)
                .sector(sector)
                .owner(owner)
                .subscriptionDate(LocalDate.parse(subscriptionDate, DateTimeFormatter.ISO_DATE))
                .status(State.PENDING)
                .employeeNumber(Long.parseLong(employeeNumber))
                .build()
                ;
    }
}


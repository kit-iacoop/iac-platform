package com.web.dto.account;

import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
@NoArgsConstructor

public class CompanyInformationDTO extends AccountInformationDTO {

//    @Size(min=1, max=50)
//    @Positive
//    @NotBlank
    private Long businessRegistrationNumber;

//    @Size(min=1, max=7)
//    @Positive
    private Long employeeNumber;

//    @Size(min=2, max=10)
//    @NotEmpty
    private String companyType;

//    @Size(min=2, max=100)
//    @NotEmpty
    private String sector;

//    @Size(min=1, max=100)
    private String owner;

//    @NotEmpty
    private String subscriptionDate;


    public Company toEntity(){
        return Company.builder()
                //공통정보
                .loginId(loginId)
                .password(password)
                .name(name)
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(new Address(city, street, zipCode))
                .email(email)
                .telephone(telephone)
                .status(State.PENDING)
                //회사정보
                .businessRegistrationNumber(businessRegistrationNumber)
                .companyType(companyType)
                .sector(sector)
                .owner(owner)
                .subscriptionDate(subscriptionDate)
                .employeeNumber(employeeNumber)
                .build()
                ;
    }
}


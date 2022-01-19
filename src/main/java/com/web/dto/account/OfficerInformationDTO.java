package com.web.dto.account;


import com.domain.account.Officer;
import com.domain.account.Professor;
import com.domain.common.Address;
import com.domain.common.State;
import com.domain.university.University;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
@NoArgsConstructor


public class OfficerInformationDTO extends AccountInformationDTO{

    @NotBlank
    private University university;

    private String officeLocation;

    public Officer toEntity(){

        return Officer.builder()
                //공통정보
                .loginId(loginId)
                .password(password)
                .name(name)
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(new Address(city, street, Long.parseLong(zipCode)))
                .email(email)
                .telephone(telephone)
                .status(State.PENDING)
                //직원정보
                .officeLocation(officeLocation)
                .build();

        // university는 매소드 밖에서 만들어 주어야 한다.

    }


}

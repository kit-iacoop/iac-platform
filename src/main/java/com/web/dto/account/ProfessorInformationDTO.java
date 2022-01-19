package com.web.dto.account;



import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.account.Professor;
import com.domain.common.Address;
import com.domain.common.State;
import com.domain.university.UniversityRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
@NoArgsConstructor


public class ProfessorInformationDTO extends AccountInformationDTO{


    @NotBlank
    private String university;

    private String officeLocation;

    @NotBlank
    private String department;



    public Professor toEntity(){

        return Professor.builder()
                //공통정보
                .loginId(loginId)
                .password(password)
                .name(name)
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(new Address(city, street, zipCode))
                .email(email)
                .telephone(telephone)
                .status(State.PENDING)
                //교수정보
                .officeLocation(officeLocation)
                .department(department)
                .build();

        // university는 매소드 밖에서 만들어 주어야 한다.

    }


}

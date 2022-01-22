package com.web.dto.account;

import com.domain.account.Student;
import com.domain.common.Address;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
@NoArgsConstructor


public class StudentInformationDTO extends AccountInformationDTO{

//    @NotBlank
    private String university;

//    @NotBlank
    private String department;

//    @NotBlank
    private Long studentNumber;

    public Student toEntity(){

        return Student.builder()
                //공통정보
                .loginId(loginId)
                .password(password)
                .name(name)
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE))
                .address(new Address(city, street, zipCode))
                .email(email)
                .telephone(telephone)
                .status(State.PENDING)
                //학생정보
                .studentNumber(studentNumber)
                .department(department)
                .build();

        // university는 매소드 밖에서 만들어 주어야 한다.

    }


}

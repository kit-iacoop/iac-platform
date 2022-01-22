package com.domain.account;

import com.domain.university.University;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.ProfessorInformationDTO;
import com.web.dto.account.StudentInformationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@SuperBuilder

@DiscriminatorValue("S")
@Table(name = "STUDENT")
@Entity
public class Student extends Account {

    @Column(name = "STUDENT_NUMBER", nullable = false)
    private Long studentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIVERSITY_ID", nullable = false)
    private University university;

    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

    @Override
    public AccountInformationDTO toInformationDTO() {
        return StudentInformationDTO.builder()
                .accountId(accountId)
                .loginId(loginId)
                .password(null)
                .name(name)
                .birthDate(birthDate.toString())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .street(address.getStreet())
                .email(email)
                .telephone(telephone)
                .status(status)
                // 교수 정보
                .university(university.getUniversityName())
                .studentNumber(studentNumber)
                .department(department)
                .build();
    }

    @Override
    public Account updateInformation(AccountInformationDTO accInfDto) {
        return null;
    }
}

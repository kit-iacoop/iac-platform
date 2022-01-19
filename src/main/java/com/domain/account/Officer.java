package com.domain.account;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.annualFeeRequest.AnnualFeeRequest;
import com.domain.mileageRequest.MileageRequest;
import com.domain.university.University;

import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.CompanyInformationDTO;
import com.web.dto.account.OfficerInformationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter

@SuperBuilder
@DiscriminatorValue("O")
@Table(name = "OFFICER")
@Entity
public class Officer extends Account {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIVERSITY_ID", nullable = false)
    private University university;

    @Column(name = "OFFICE_LOCATION", nullable = false)
    private String officeLocation;

    @Builder.Default
    @OneToMany(mappedBy = "officer", fetch = FetchType.LAZY)
    private List<MileageRequest> mileageRequest = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "officer", fetch = FetchType.LAZY)
    private List<AnnualFeeRequest> annualFeeRequest = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "officer")
    private List<CollaboRequest> collaboRequest = new ArrayList<>();

    @Override
    public OfficerInformationDTO toInformationDTO() {
        return OfficerInformationDTO.builder()
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
                // 직원 정보
                .university(university.getUniversityName())
                .officeLocation(officeLocation)
                .build();
    }
}

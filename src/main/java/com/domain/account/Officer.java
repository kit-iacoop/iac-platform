package com.domain.account;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.annualFeeRequest.AnnualFeeRequest;
import com.domain.mileageRequest.MileageRequest;
import com.domain.university.University;

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

    @OneToMany(mappedBy = "officer", fetch = FetchType.LAZY)
    private List<MileageRequest> mileageRequest = new LinkedList<>();

    @OneToMany(mappedBy = "officer", fetch = FetchType.LAZY)
    private List<AnnualFeeRequest> annualFeeRequest = new LinkedList<>();

    @OneToMany(mappedBy = "officer")
    private List<CollaboRequest> collaboRequest = new ArrayList<>();

}

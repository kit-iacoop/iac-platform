package com.domain.Account;

import com.domain.Account.Account;
import com.domain.CollaboRequest.CollaboRequest;
import com.domain.AnnualFeeRequest.AnnualFeeRequest;
import com.domain.MileageRequest.MileageRequest;
import com.domain.University.University;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter

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
    private List<MileageRequest> mileageRequest;

    @OneToMany(mappedBy = "officer", fetch = FetchType.LAZY)
    private List<AnnualFeeRequest> annualFeeRequest;

    @OneToMany(mappedBy = "officer")
    private List<CollaboRequest> collaboRequest = new ArrayList<>();

}

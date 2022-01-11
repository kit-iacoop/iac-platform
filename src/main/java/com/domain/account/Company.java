package com.domain.account;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.companyAnnualSales.CompanyAnnualSales;
import com.domain.item.Item;
import com.domain.project.Project;
import com.domain.annualFeeRequest.AnnualFeeRequest;
import com.domain.companyMileage.CompanyMileage;
import com.domain.mileageRequest.MileageRequest;

import com.domain.common.State;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder

@ToString(callSuper=true, exclude = {"temporaryAddress", "collaboRequest", "mileageRequest", "itemList", "projectList", "mileageList","annualFeeRequest","mentorProfessor", "annualSalesList"})

@DiscriminatorValue("C")
@Table(name = "COMPANY")
@Entity
public class Company extends Account {

    @Column(name = "BUSINESS_REGISTRATION_NUMBER", nullable = false)
    private Long businessRegistrationNumber;

    @Column(name = "EMPLOYEE_NUMBER", nullable = false) // 임시 nullable
    private Long employeeNumber;

    @Column(name = "SECTOR", nullable = false)
    private String sector; // 업종.. ?

    @Column(name = "OWNER", nullable = false)
    private String owner;

    @Column(name = "GRADE", nullable = false)
    private String grade;

    @Column(name = "COMPANY_TYPE", nullable = false)
    private String companyType;

    @Column(name = "TEMPORARY_ADDRESS", nullable = true)
    private String temporaryAddress;

    @Column(name = "MILEAGE", nullable = false)
    private Long mileage;

    @Column(name = "POINT", nullable = false)
    private Long point;

    @Column(name = "SUBSCRIPTION_DATE", nullable = true)
    private LocalDate subscriptionDate; // 협약일

    @Column(name = "CURRENTIZATION_STATUS", nullable = false)
    private State currentizationStatus; // 현행화 상태

    @OneToMany(mappedBy = "company")
    private List<CollaboRequest> collaboRequest;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<MileageRequest> mileageRequest;

    @OneToMany(mappedBy = "company")
    private List<Item> itemList;

    @OneToMany(mappedBy = "company")
    private List<Project> projectList;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyMileage> mileageList;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<AnnualFeeRequest> annualFeeRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENTOR_PROFESSOR")
    private Professor mentorProfessor;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyAnnualSales> annualSalesList;

    public void verification(String grade, Long mileage, Long point, State currentizationStatus){
        this.grade = grade;
        this.mileage = mileage;
        this.point = point;
        this.currentizationStatus = currentizationStatus;
    }
}
package com.domain.account;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.companyAnnualSales.CompanyAnnualSales;
import com.domain.item.Item;
import com.domain.project.Project;
import com.domain.annualFeeRequest.AnnualFee;
import com.domain.companyMileage.CompanyMileage;
import com.domain.mileageRequest.MileageRequest;

import com.domain.common.State;
import com.web.dto.account.CompanyInformationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
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

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<CollaboRequest> collaboRequest = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<MileageRequest> mileageRequest = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<Item> itemList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<Project> projectList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyMileage> mileageList = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<AnnualFee> annualFee = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENTOR_PROFESSOR")
    private Professor mentorProfessor;

    @Builder.Default
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyAnnualSales> annualSalesList = new LinkedList<>();

    public void verification(String grade, Long mileage, Long point, State currentizationStatus){
        this.grade = grade;
        this.mileage = mileage;
        this.point = point;
        this.currentizationStatus = currentizationStatus;
    }

    @Override
    public CompanyInformationDTO toInformationDTO() {
        return CompanyInformationDTO.builder()
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
                // 회사 정보
                .businessRegistrationNumber(businessRegistrationNumber)
                .employeeNumber(employeeNumber)
                .companyType(companyType)
                .sector(sector)
                .owner(owner)
                .subscriptionDate(subscriptionDate.toString())
                .build();
    }
}

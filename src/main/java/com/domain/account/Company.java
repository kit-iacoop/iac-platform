package com.domain.account;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.common.Address;
import com.domain.companyAnnualSales.CompanyAnnualSales;
import com.domain.item.Item;
import com.domain.project.Project;
import com.domain.annualFee.AnnualFee;
import com.domain.companyMileage.CompanyMileage;

import com.domain.common.State;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.CompanyInformationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder

@ToString(callSuper=true, exclude = {"temporaryAddress", "collaboRequest", "mileageRequest", "itemList", "projectList", "mileageList","annualFee","mentorProfessor", "annualSalesList"})

@DiscriminatorValue("C")
@Table(name = "COMPANY")
@Entity
public class Company extends Account {

    @Column(name = "BUSINESS_REGISTRATION_NUMBER", nullable = false)
    private Long businessRegistrationNumber;

    @Column(name = "EMPLOYEE_NUMBER", nullable = false) // 임시 nullable
    private Long employeeNumber;

    @Column(name = "SECTOR", nullable = true)
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
    private String subscriptionDate; // 협약일

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENTIZATION_STATUS", nullable = false)
    private State currentizationStatus; // 현행화 상태


    // additional field
    @Column(name = "MENTOR_PROF_RONLY", nullable = true)
    private String mentorProfessorROnly;

    @Column(name = "MENTOR_PROF_DEPT_RONLY", nullable = true)
    private String mentorProfessorDeptROnly;

    @Column(name = "MENTOR_PROF_RET", nullable = true)
    private Boolean mentorProfessorRET;

    @Column(name = "CLOSURE", nullable = true)
    private Boolean closure;

    @Column(name = "CLOSURE_DATE", nullable = true)
    private String closureDate;



    // relation field

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<CollaboRequest> collaboRequest = new LinkedList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyMileage> companyMileage = new LinkedList<>();

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



    // methods

    public void renewGrade(String newGrade){
        grade = newGrade;
    }
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

    @Override
    public Account updateInformation(AccountInformationDTO accInfDto) {

        CompanyInformationDTO accDto = (CompanyInformationDTO) accInfDto;

        name = accDto.getName();
        birthDate = LocalDate.parse(accDto.getBirthDate(), DateTimeFormatter.ISO_DATE);
        password = accDto.getPassword();
        email = accDto.getEmail();
        address = new Address(accDto.getCity(), accDto.getStreet(), accDto.getZipCode());
        owner = accDto.getOwner();
        companyType = accDto.getCompanyType();
        sector = accDto.getSector();
        employeeNumber = accDto.getEmployeeNumber();
        telephone = accDto.getTelephone();
        businessRegistrationNumber = accDto.getBusinessRegistrationNumber();
        subscriptionDate = accDto.getSubscriptionDate();

        return this;
    }

    public Long usePoint(Long point){

        if( this.point < point){
            // throw 잔액부족 예외 발생
            return null;
        }

        return (this.point -= point);
    }

    public Long refundPoint(Long point){
        return (this.point += point);
    }


    @Override
    public void acceptRegistration() {
        if(!status.equals(State.PENDING)){
//            throw Exception()
        }
        status = State.NORMAL;

    }

    @Override
    public void rejectRegistration() {
        if(!status.equals(State.PENDING)){
//            throw Exception()
        }
        status = State.REJECTED;

    }

    public Long savePoint(Long value){
        return (point += value);
    }

    public Long saveMileage(Long value){
        return (mileage += value);
    }
}

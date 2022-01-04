package com.domain.Account.Company;

import com.domain.Account.Account;
import com.domain.CollaboRequest.CollaboRequest;
import com.domain.Item.Item;
import com.domain.Project.Project;
import com.domain.AnnualFeeRequest.AnnualFeeRequest;
import com.domain.CompanyMileage.CompanyMileage;
import com.domain.MileageRequest.MileageRequest;
import com.domain.common.BaseTimeEntity;

import com.domain.common.GradeType;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@NoArgsConstructor
@Getter

@DiscriminatorValue("C")
@Table(name = "COMPANY")
@Entity
public class Company extends Account {

    @Column(name = "EMPLOYEE_NUMBER", nullable = false)
    private Long employeeNumber;

    @Column(name = "SECTOR", nullable = false)
    private String sector;

    @Column(name = "OWNER", nullable = false)
    private String owner;

    @Enumerated
    @Column(name = "GRADE", nullable = false)
    private GradeType grade;

    @Column(name = "MILEAGE", nullable = false)
    private Long mileage;

    @Column(name = "POINT", nullable = false)
    private Long point;

   @Column(name = "CURRENTIZATION_STATUS", nullable = false)
   private State currentizationStatus;

    @OneToMany(mappedBy = "companyAccountId")
    private List<CollaboRequest> collaboRequest = new ArrayList<>();

   @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
   private List<MileageRequest> mileageRequest;

    @OneToMany(mappedBy = "companyId")
    private List<Item> itemList = new ArrayList<>();

    @OneToMany(mappedBy = "companyAccountId")
    private List<Project> projectList = new ArrayList<>();

   @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
   private List<CompanyMileage> mileageList;

   @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
   private List<AnnualFeeRequest> annualFeeRequest;
}

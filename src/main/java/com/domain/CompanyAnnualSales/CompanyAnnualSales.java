package com.domain.CompanyAnnualSales;

import com.domain.Account.Company;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "COMPANY_ANNUAL_SALES")
public class CompanyAnnualSales  extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ANNUAL_SALES_ID", nullable = false, unique = true)
    private Long companyAnnualSalesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Company company;

    @Column(name = "YEAR", nullable = false)
    private Long year;

    @Column(name = "SALES", nullable = false)
    private Long sales;
}

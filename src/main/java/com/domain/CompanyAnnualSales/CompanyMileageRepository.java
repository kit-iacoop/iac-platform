package com.domain.CompanyAnnualSales;

import com.domain.CompanyMileage.CompanyMileage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMileageRepository extends JpaRepository<CompanyAnnualSales, Long> {

}

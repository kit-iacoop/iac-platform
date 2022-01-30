package com.domain.companyMileage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMileageRepository extends JpaRepository<CompanyMileage, Long> {

    CompanyMileage findByCompanyMileageId(Long mileageRequestId);
}

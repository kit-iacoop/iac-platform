package com.domain.companyMileage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMileageRepository extends JpaRepository<CompanyMileage, Long>, CompanyMileageRepositoryCustom {

    CompanyMileage findByCompanyMileageId(Long mileageRequestId);
}

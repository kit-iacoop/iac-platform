package com.domain.annualFeeRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnualFeeRepository extends JpaRepository<AnnualFee, Long> {
    AnnualFee findByAnnualFeeId(Long id);
}

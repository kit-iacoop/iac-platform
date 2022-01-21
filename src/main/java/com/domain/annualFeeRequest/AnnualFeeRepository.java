package com.domain.annualFeeRequest;

import com.web.dto.AnnualFeeHistoryDTO;
import com.web.dto.PendingCompanyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnualFeeRepository extends JpaRepository<AnnualFee, Long> {
    AnnualFee findByAnnualFeeId(Long id);

    @Query("select new com.web.dto.AnnualFeeHistoryDTO(af.year, gp.grade, af.cash, af.point, af.confirmDate) from AnnualFee af join af.gradePolicy gp where af.company.accountId = :companyId")
    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);

}

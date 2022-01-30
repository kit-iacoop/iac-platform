package com.domain.companyMileage;

import com.web.dto.mileage.MileageHistoryDTO;

import java.util.List;

public interface CompanyMileageRepositoryCustom {
    List<MileageHistoryDTO> findAllHistoryDTOByCompanyId(Long accountId);
}

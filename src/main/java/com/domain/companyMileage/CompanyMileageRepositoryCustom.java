package com.domain.companyMileage;

import com.web.dto.mileage.QueryOptionDTO;
import com.web.dto.mileage.MileageHistoryDTO;

import java.util.List;

public interface CompanyMileageRepositoryCustom {
    List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO qoption);

    List<MileageHistoryDTO> findAllHistoryDTOWithDOption(QueryOptionDTO queryOptionDTO);

    MileageHistoryDTO findHistoryDTOById(Long activityId);
}

package com.web.service;

import com.web.dto.mileage.MileageHistoryDTO;
import com.web.dto.mileage.QueryOptionDTO;

import java.util.List;

public interface CompanyMileageService {
    List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO queryOptionDTO);
    List<MileageHistoryDTO> findAllHistoryDTOWithDOption(QueryOptionDTO queryOptionDTO);

    MileageHistoryDTO findHistoryDTOById(Long activityId);
}

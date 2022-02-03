package com.web.service;

import com.web.dto.mileage.MileageHistoryDTO;
import com.web.dto.mileage.QueryOptionDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CompanyMileageService {
    List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO queryOptionDTO);
    List<MileageHistoryDTO> findAllHistoryDTOWithDOption(QueryOptionDTO queryOptionDTO);

    void createCompanyMileage(Long midCtg, Long cnt, LocalDateTime start, LocalDateTime end);
    MileageHistoryDTO findHistoryDTOById(Long activityId);

    void acceptMileage(Long id);

    void rejectMileage(Long id);
}

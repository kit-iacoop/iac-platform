package com.web.service.Impl;

import com.domain.companyMileage.CompanyMileageRepository;
import com.web.dto.mileage.MileageHistoryDTO;
import com.web.dto.mileage.QueryOptionDTO;
import com.web.service.CompanyMileageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CompanyMileageServiceImpl implements CompanyMileageService {

    private final CompanyMileageRepository companyMileageRepository;

    @Override
    public List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO queryOptionDTO) {
        return companyMileageRepository.findAllHistoryDTOByCompanyIdAndDOption(accountId, queryOptionDTO);
    }

    @Override
    public List<MileageHistoryDTO> findAllHistoryDTOWithDOption(QueryOptionDTO queryOptionDTO) {
        return companyMileageRepository.findAllHistoryDTOWithDOption(queryOptionDTO);
    }

    @Override
    public MileageHistoryDTO findHistoryDTOById(Long activityId) {
        return companyMileageRepository.findHistoryDTOById(activityId);
    }
}

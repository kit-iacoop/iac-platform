package com.web.service.Impl;

import com.domain.annualFeeRequest.AnnualFeeRepository;
import com.web.dto.AnnualFeeHistoryDTO;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnnualFeeServiceImpl implements AnnualFeeService {

    AnnualFeeRepository annualFeeRepository;
    @Override
    public List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId) {
        return annualFeeRepository.findAllHistoryDtoByCompanyId(companyId);
    }
}

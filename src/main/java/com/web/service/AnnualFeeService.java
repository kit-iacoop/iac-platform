package com.web.service;

import com.web.dto.AnnualFeeHistoryDTO;

import java.util.List;

public interface AnnualFeeService {

    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);

}

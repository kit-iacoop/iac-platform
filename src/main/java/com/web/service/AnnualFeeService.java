package com.web.service;

import com.web.dto.AnnualFeeHistoryDTO;
import com.web.dto.AnnualFeeInfoDTO;

import java.util.List;

public interface AnnualFeeService {

    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);
    List<AnnualFeeInfoDTO> findAllInfoDto();

}

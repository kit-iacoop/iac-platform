package com.web.service;

import com.domain.annualFee.AnnualFee;
import com.web.dto.annualfee.AnnualFeeHistoryDTO;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.QueryOptionDTO;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface AnnualFeeService {

    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);
    List<AnnualFeeInfoDTO> findAllInfoDto();

    void acceptPayments(List<Long> idList);
    void rejectPayments(List<Long> idList);

    List<AnnualFeeInfoDTO> findInfoDtoListWithQDsl(QueryOptionDTO queryOption);

    AnnualFee requestPayment(Long gradePolicyId, Long point, Long cash);
}

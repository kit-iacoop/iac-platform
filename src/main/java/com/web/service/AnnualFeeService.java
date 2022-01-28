package com.web.service;

import com.web.dto.annualfee.AnnualFeeHistoryDTO;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.QueryOptionDTO;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface AnnualFeeService {

    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);
    List<AnnualFeeInfoDTO> findAllInfoDto();

    void acceptPayment(ModelAndView mav, Long paymentId);
    void rejectPayment(ModelAndView mav, Long paymentId);

    List<AnnualFeeInfoDTO> findInfoDtoListWithQDsl(QueryOptionDTO queryOption);
}

package com.web.service;

import com.domain.annualFee.AnnualFee;
import com.web.dto.AnnualFeeHistoryDTO;
import com.web.dto.AnnualFeeInfoDTO;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface AnnualFeeService {

    List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId);
    List<AnnualFeeInfoDTO> findAllInfoDto();

    void acceptPayment(ModelAndView mav, Long paymentId);
    void rejectPayment(ModelAndView mav, Long paymentId);
}

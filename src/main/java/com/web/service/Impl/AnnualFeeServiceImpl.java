package com.web.service.Impl;

import com.domain.annualFee.AnnualFee;
import com.domain.annualFee.AnnualFeeRepository;
import com.web.dto.AnnualFeeHistoryDTO;

import com.web.dto.AnnualFeeInfoDTO;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class AnnualFeeServiceImpl implements AnnualFeeService {

    AnnualFeeRepository annualFeeRepository;

    @Override
    public List<AnnualFeeInfoDTO> findAllInfoDto() {
        return annualFeeRepository.findAllInfoDto();
    }

    @Override
    public List<AnnualFeeHistoryDTO> findAllHistoryDtoByCompanyId(Long companyId) {

        return annualFeeRepository.findAllHistoryDtoByCompanyId(companyId);
    }

    @Transactional
    @Override
    public void acceptPayment(ModelAndView mav, Long paymentId) {

        AnnualFee payment = annualFeeRepository.findByAnnualFeeId(paymentId);
        Boolean isSuccess = payment.accept();

        if(!isSuccess){
            mav.addObject("error", true);
        }

    }

    @Transactional
    @Override
    public void rejectPayment(ModelAndView mav, Long paymentId) {
        AnnualFee payment = annualFeeRepository.findByAnnualFeeId(paymentId);
        payment.reject();
    }

}

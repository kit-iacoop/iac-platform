package com.web.service.Impl;

import com.common.Common;
import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.account.Company;
import com.domain.annualFee.AnnualFee;
import com.domain.annualFee.AnnualFeeRepository;
import com.domain.common.State;
import com.domain.gradePolicy.GradePolicyRepository;
import com.web.dto.annualfee.AnnualFeeHistoryDTO;

import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.*;
import com.web.service.AnnualFeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class AnnualFeeServiceImpl implements AnnualFeeService {

    private final AnnualFeeRepository annualFeeRepository;
    private final GradePolicyRepository gradePolicyRepository;
    private final Common common;
    private final AccountRepository accountRepository;

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
    public void acceptPayments(List<Long>  idList) {

        for(Long id : idList){
            AnnualFee payment = annualFeeRepository.findByAnnualFeeId(id);
            payment.accept();
        }

    }

    @Transactional
    @Override
    public void rejectPayments(List<Long>  idList) {

        for (Long id : idList) {
            AnnualFee payment = annualFeeRepository.findByAnnualFeeId(id);
            payment.reject();
        }

    }
    @Override
    public List<AnnualFeeInfoDTO> findInfoDtoListWithQDsl(QueryOptionDTO queryOption) {

        return annualFeeRepository.findInfoDtoListWithQDsl(queryOption);
    }

    @Transactional
    @Override
    public AnnualFee requestPayment(Long gradePolicyId, Long point, Long cash) {

        // 중복 생성 못하도록 예외처리 필요
        Long id = common.getAccountContext().getAccount().getAccountId();
        Company company = (Company)accountRepository.findByAccountId(id);

        System.out.println(company.usePoint(point)); // 잔액부족 예외

        return annualFeeRepository.save(AnnualFee.builder()
                .company((Company) common.getAccountContext().getAccount())
                .gradePolicy(gradePolicyRepository.findByGradePolicyId(gradePolicyId))
                .point(point)
                .cash(cash)
                .year(LocalDate.now().getYear())
                .paymentStatus(State.PENDING)
                .build());

    }

}

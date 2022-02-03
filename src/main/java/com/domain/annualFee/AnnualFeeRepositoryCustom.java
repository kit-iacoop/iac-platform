package com.domain.annualFee;

import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.*;

import java.util.List;
import java.util.Map;

public interface AnnualFeeRepositoryCustom {
    public List<AnnualFeeInfoDTO> findInfoDtoListWithQDsl(QueryOptionDTO queryOption);
}

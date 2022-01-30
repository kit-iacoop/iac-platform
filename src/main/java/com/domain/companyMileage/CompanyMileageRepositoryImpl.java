package com.domain.companyMileage;


import static com.domain.companyMileage.QCompanyMileage.companyMileage;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.mileage.QueryOptionDTO;
import com.web.dto.mileage.MileageHistoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CompanyMileageRepositoryImpl implements CompanyMileageRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO qoption) {


        return jpaQueryFactory
                .select(Projections.constructor(MileageHistoryDTO.class,
                        companyMileage.companyMileageId,
//                        companyMileage.mileagePolicy.collaborationCategory.parentCategory.collaborationName,
                        companyMileage.mileagePolicy.collaborationCategory.collaborationName,
                        companyMileage.achievementCnt,
                        companyMileage.status,
                        companyMileage.mileagePolicy.mileage,
                        companyMileage.mileagePolicy.point,
                        companyMileage.startDate,
                        companyMileage.endDate
                        ))
                .from(companyMileage)
                .where(companyMileage.company.accountId.eq(accountId)
                        .and(qoption.getQueryBuilder())
                )
                .fetch();

    }
}
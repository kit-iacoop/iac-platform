package com.domain.annualFee;
import static com.domain.annualFee.QAnnualFee.annualFee;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.dto.annualfee.AnnualFeeInfoDTO;
import com.web.dto.annualfee.QueryOptionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class AnnualFeeRepositoryCustomImpl implements AnnualFeeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public List<AnnualFeeInfoDTO> findInfoDtoListWithQDsl(QueryOptionDTO queryOption){

        return jpaQueryFactory.selectFrom(annualFee)
                .select(Projections.constructor(AnnualFeeInfoDTO.class
                        , annualFee.annualFeeId
                        , annualFee.year
                        , annualFee.gradePolicy.grade
                        , annualFee.company.name
                        , annualFee.cash
                        , annualFee.point
                        , annualFee.paymentStatus
                        , annualFee.confirmDate
                        )
                )
                .where(queryOption.getQueryBuilder())
                .fetch();
    }

}


package com.web.dto.mileage;

import static com.domain.companyMileage.QCompanyMileage.companyMileage;
import com.domain.common.State;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.domain.annualFee.QAnnualFee.annualFee;


@Getter
@Setter
@ToString

public class QueryOptionDTO {


    State state;

    public State getState() {
        return state;
    }

    public BooleanBuilder getQueryBuilder(){

        BooleanBuilder builder = new BooleanBuilder();

        if(state != null){
            builder.and(companyMileage.status.eq(state));
        }

        return builder;
    }
}

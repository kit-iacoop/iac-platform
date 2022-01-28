package com.web.dto.annualfee;

import com.domain.common.State;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.qdomain.annualFee.QAnnualFee.annualFee;


@Setter
@ToString

public class QueryOptionDTO {

    String companyName;
    String startDay;
    String endDay;
    State state;

    public String getCompanyName() {
        return companyName;
    }
    public LocalDateTime getStartDayTime() {

        if(startDay == null){
            return null;
        }

        return LocalDate.parse(startDay, DateTimeFormatter.ISO_DATE).atStartOfDay();
    }

    public LocalDateTime getEndDayTime() {
        if(endDay == null){
            return null;
        }

        return LocalDate.parse(endDay, DateTimeFormatter.ISO_DATE).atStartOfDay();
    }

    public State getState() {
        return state;
    }

    public BooleanBuilder getQueryBuilder(){

        BooleanBuilder builder = new BooleanBuilder();

        if(companyName != null){
            builder.and(annualFee.company.name.eq(companyName));
        }

        if(startDay != null){
            builder.and(annualFee.createdDate.after(getStartDayTime()));
        }

        if(endDay != null){
            builder.and(annualFee.createdDate.before(getEndDayTime()));
        }

        if(state != null){
            builder.and(annualFee.paymentStatus.eq(state));
        }

        return builder;
    }
}

package com.web.dto.annualfee;
import static com.domain.annualFee.QAnnualFee.annualFee;

import com.domain.annualFee.QAnnualFee;
import com.domain.common.State;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@ToString

public class QueryOptionDTO {
    static final QAnnualFee annualFee = QAnnualFee.annualFee;


    String companyName;
    String startDay;
    String endDay;
    State state;

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDateTime getStartDayTime() {

        if (startDay == null) {
            return null;
        }

        return LocalDate.parse(startDay, DateTimeFormatter.ISO_DATE).atStartOfDay();
    }

    public LocalDateTime getEndDayTime() {
        if (endDay == null) {
            return null;
        }

        return LocalDate.parse(endDay, DateTimeFormatter.ISO_DATE).atStartOfDay();
    }

    public State getState() {
        return state;
    }

    public BooleanBuilder getQueryBuilder() {

        BooleanBuilder builder = new BooleanBuilder();

        if (companyName != null) {
            builder.and(annualFee.company.name.contains(companyName));
        }

        if (startDay != null) {
            builder.and(annualFee.createdDate.after(getStartDayTime()));
        }

        if (endDay != null) {
            builder.and(annualFee.createdDate.before(getEndDayTime()));
        }

        if (state != null) {
            builder.and(annualFee.paymentStatus.eq(state));
        }

        return builder;
    }

}

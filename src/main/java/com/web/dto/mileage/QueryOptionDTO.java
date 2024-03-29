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



@Getter
@Setter
@ToString
public class QueryOptionDTO {

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
            builder.and(companyMileage.company.name.contains(companyName));
        }

        if(startDay != null){
            builder.and(companyMileage.createdDate.after(getStartDayTime()));
        }

        if(endDay != null){
            builder.and(companyMileage.createdDate.before(getEndDayTime()));
        }

        if(state != null){
            builder.and(companyMileage.status.eq(state));
        }

        return builder;
    }
}

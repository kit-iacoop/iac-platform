package com.web.dto.annualfee;

import com.domain.common.State;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnualFeeHistoryDTO {

    private Integer year;
    private String grade;
    private Long cash;
    private Long point;
    private State paymentStatus;
    private LocalDate confirmDate;

}

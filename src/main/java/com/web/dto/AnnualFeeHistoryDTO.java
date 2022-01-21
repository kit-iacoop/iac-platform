package com.web.dto;

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
    private LocalDate confirmDate;

}

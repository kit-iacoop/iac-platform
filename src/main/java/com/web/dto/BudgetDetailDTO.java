package com.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDetailDTO {
    private String budgetDetailId;
    private String projectId;
    private String total;
    private String humanCostRate;
    private String researchActivityRate;
    private String indirectCostRate;
}

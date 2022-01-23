package com.web.dto;

import com.domain.budgetDetail.BudgetDetail;
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

    public BudgetDetailDTO(BudgetDetail budgetDetail) {
        this.budgetDetailId = String.valueOf(budgetDetail.getBudgetDetailId());
        this.projectId = String.valueOf(budgetDetail.getProject().getProjectId());
        this.total = budgetDetail.getTotal();
        this.humanCostRate = budgetDetail.getHumanCost();
        this.researchActivityRate = budgetDetail.getResearchActivity();
        this.indirectCostRate = budgetDetail.getIndirectCost();
    }
}

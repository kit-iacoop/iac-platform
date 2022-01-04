package com.domain.BudgetDetail;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "BUDGET_DETAIL")
public class BudgetDetail extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_DETAIL_ID", nullable = false)
    private Long budgetDetailId;

    @Column(name = "TOTAL", nullable = false)
    private Long total;

    @Column(name = "HUMAN_COST", nullable = false)
    private Long humanCost;

    @Column(name = "RESEARCH_ACTIVITY", nullable = false)
    private Long researchActivity;

    @Column(name = "INDIRECT_COST", nullable = false)
    private Long indirectCost;


}

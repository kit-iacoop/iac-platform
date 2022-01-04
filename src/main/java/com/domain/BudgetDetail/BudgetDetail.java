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
    // 소수점 단위가 들어가게 됨. 정확한 계산이 필요로 할 것으로 생각됨
    // String 으로 관리하고, 서비스계층에서 변환하여 사용하는게 좋아보임

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_DETAIL_ID", nullable = false)
    private Long budgetDetailId;

    @Column(name = "TOTAL", nullable = false)
    private String total;

    @Column(name = "HUMAN_COST", nullable = false)
    private String humanCost;

    @Column(name = "RESEARCH_ACTIVITY", nullable = false)
    private String researchActivity;

    @Column(name = "INDIRECT_COST", nullable = false)
    private String indirectCost;


}

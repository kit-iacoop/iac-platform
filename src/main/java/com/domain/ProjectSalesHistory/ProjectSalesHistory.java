package com.domain.ProjectSalesHistory;

import com.domain.common.BaseTimeEntity;

import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT_SALES_HISTORY")
public class ProjectSalesHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_SALES_HISTORY_ID", nullable = false)
    private Long projectSalesHistoryId;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @Column(name = "YEAR", nullable = false)
    private String year;

    // 매출액 관련 필드. 위의 Budget과 같이 금액관련 필드는 모두 String으로 처리
    @Column(name = "SALES", nullable = false)
    private String sales;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

}

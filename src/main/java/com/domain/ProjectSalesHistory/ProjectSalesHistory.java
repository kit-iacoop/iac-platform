package com.domain.ProjectSalesHistory;

import com.domain.common.BaseTimeEntity;

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
    private Long year;

    @Column(name = "SALES", nullable = false)
    private Long sales;

    // TODO: enum 형태로 되어야할듯
    @Column(name = "STATUS", nullable = false)
    private String status;


}

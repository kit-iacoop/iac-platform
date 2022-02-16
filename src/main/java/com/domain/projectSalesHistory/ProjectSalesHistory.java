package com.domain.projectSalesHistory;

import com.domain.project.Project;
import com.domain.salesHistoryProofFile.SalesHistoryProofFile;
import com.domain.common.BaseTimeEntity;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@SuperBuilder
@Table(name = "PROJECT_SALES_HISTORY")
public class ProjectSalesHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_SALES_HISTORY_ID", nullable = false)
    private Long projectSalesHistoryId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;

    @Column(name = "YEAR", nullable = false)
    private String year;

    // 매출액 관련 필드. 위의 Budget과 같이 금액관련 필드는 모두 String으로 처리
    @Column(name = "SALES", nullable = false)
    private String sales;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

    @OneToMany(mappedBy = "projectSalesHistory", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<SalesHistoryProofFile> proofFileList = new ArrayList<>();

    public void setProject(Project projectId) {
        if (this.project != null) {
            this.project.getSalesHistoryList().remove(this);
        }
        this.project = projectId;
        projectId.getSalesHistoryList().add(this);
    }
}

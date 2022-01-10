package com.domain.salesHistoryProofFile;

import com.domain.projectSalesHistory.ProjectSalesHistory;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "SALES_HISTORY_PROOF_FILE")
public class SalesHistoryProofFile extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALES_HISTORY_PROOF_FILE_ID", nullable = false)
    private Long salesHistoryProofFileId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_SALES_HISTORY_ID", nullable = false)
    private ProjectSalesHistory projectSalesHistory;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false)
    private String filePath;

    @Column(name = "FILE_SIZE", nullable = false)
    private String fileSize;

    public void setProjectSalesHistory(ProjectSalesHistory projectSalesHistoryId) {
        if (this.projectSalesHistory != null) {
            this.projectSalesHistory.getProofFileList().remove(this);
        }
        this.projectSalesHistory = projectSalesHistoryId;
        projectSalesHistoryId.getProofFileList().add(this);
    }
}

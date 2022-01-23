package com.web.dto;

import com.domain.projectSalesHistory.ProjectSalesHistory;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSalesHistoryDTO {

    private String projectSalesHistoryId;
    private String projectId;
    private String year;
    private String sales;
    private String status;
    private List<ProofFileDTO> proofFileDTOList;

    public ProjectSalesHistoryDTO(ProjectSalesHistory projectSalesHistory) {
        this.projectSalesHistoryId = String.valueOf(projectSalesHistory.getProjectSalesHistoryId());
        this.projectId = String.valueOf(projectSalesHistory.getProject().getProjectId());
        this.year = projectSalesHistory.getYear();
        this.sales = projectSalesHistory.getSales();
        this.status = String.valueOf(projectSalesHistory.getStatus());
        this.proofFileDTOList = projectSalesHistory.getProofFileList().stream().map(ProofFileDTO::new).collect(Collectors.toList());
    }
}

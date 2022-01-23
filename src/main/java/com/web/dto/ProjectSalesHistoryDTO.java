package com.web.dto;

import lombok.*;

import java.util.List;

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
}

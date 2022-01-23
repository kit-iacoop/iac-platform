package com.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String projectId;
    private String collaboRequestId;

    private BudgetDetailDTO budgetDetail;

    private String companyId;
    private String companyName;
    private String startDate;
    private String endDate;

    private List<MeetingDTO> meetingDTOList;
    private List<ProjectOutputDTO> outputDTOS;
    private List<ProjectProfessorDTO> projectProfessorDTOList;
    private List<ProjectSalesHistoryDTO> projectSalesHistoryDTOList;
}

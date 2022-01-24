package com.web.dto;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.project.Project;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String projectId;
    private CollaboRequestDTO collaboRequestId = null;

    private BudgetDetailDTO budgetDetail = null;

    private String companyId;
    private String companyName;
    private String startDate;
    private String endDate;

    private List<MeetingDTO> meetingDTOList;
    private List<ProjectOutputDTO> outputDTOS;
    private List<ProjectProfessorDTO> projectProfessorDTOList;
    private List<ProjectSalesHistoryDTO> projectSalesHistoryDTOList;

    public ProjectDTO(Project project) {
        this.projectId = String.valueOf(project.getProjectId());
        this.companyId = String.valueOf(project.getCompany().getAccountId());
        this.companyName = project.getCompany().getName();
        this.startDate = String.valueOf(project.getStartDate());
        this.endDate = String.valueOf(project.getEndDate());

        this.meetingDTOList = project.getMeetingList().stream().map(MeetingDTO::new).collect(Collectors.toList());
        this.outputDTOS = project.getProjectOutputList().stream().map(ProjectOutputDTO::new).collect(Collectors.toList());
        this.projectProfessorDTOList = project.getProfessorList().stream().map(ProjectProfessorDTO::new).collect(Collectors.toList());
        this.projectSalesHistoryDTOList = project.getSalesHistoryList().stream().map(ProjectSalesHistoryDTO::new).collect(Collectors.toList());
    }

    // request를 이용해서 project 생성 시 dto매핑해서 controller로 반환
    public ProjectDTO(CollaboRequest request) {

    }
}

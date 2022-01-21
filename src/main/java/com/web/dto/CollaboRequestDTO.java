package com.web.dto;


import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.meeting.Meeting;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CollaboRequestDTO {

    // not null column list
    private String collaboRequestId;
    private String officerId;
    private String officerName;
    private String companyId;
    private String companyName;
    private String title;
    private String term;
    private String expireDate;
    private String description;
    private String status;
    private String requestType;
    private String budget;

    // nullable true column list
    private String projectId;

    // Key - pk / Value - name(value)
    private Map<String, String> collaboRequestProfessorList;
    private Map<String, String> collaboRequestTechniqueList;

    private List<Meeting> meetingList;

    public CollaboRequestDTO(CollaboRequest collaboRequest) {

        this.collaboRequestId = String.valueOf(collaboRequest.getCollaboRequestId());
        this.officerId = String.valueOf(collaboRequest.getOfficer().getAccountId());
        this.officerName = collaboRequest.getOfficer().getName();
        this.companyId = String.valueOf(collaboRequest.getCompany().getAccountId());
        this.companyName = collaboRequest.getCompany().getName();
        this.title = collaboRequest.getTitle();
        this.term = collaboRequest.getTerm();
        this.expireDate = String.valueOf(collaboRequest.getExpireDate());
        this.description = collaboRequest.getDescription();
        this.status = String.valueOf(collaboRequest.getStatus());
        this.requestType = String.valueOf(collaboRequest.getRequestType());
        this.budget = collaboRequest.getBudget();
        if (collaboRequest.getProjectId() != null) {
            this.projectId = String.valueOf(collaboRequest.getProjectId().getProjectId());
        }
        collaboRequestProfessorList = new HashMap<>();
        collaboRequestTechniqueList = new HashMap<>();

        List<CollaboRequestProfessor> requestProfessors = collaboRequest.getCollaboRequestProfessorList();
        List<CollaboRequestTechnique> requestTechniques = collaboRequest.getCollaboRequestTechniqueList();
        for (CollaboRequestProfessor e : requestProfessors) {
            collaboRequestProfessorList.put(String.valueOf(e.getProfessor().getAccountId()), e.getProfessor().getName());
        }
        for (CollaboRequestTechnique e : requestTechniques) {
            collaboRequestTechniqueList.put(String.valueOf(e.getFieldCategory().getFieldCategoryId()), e.getFieldCategory().getCategoryName());
        }
    }
}

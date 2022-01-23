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
    private String isCapstone;

    // nullable true column list
    private String projectId = null;


    // presentation layer 에서 사용되지 않는 정보
    private List<CollaboRequestProfessor> collaboRequestProfessorList = null;
    private List<CollaboRequestTechnique> collaboRequestTechniqueList = null;
    private List<Meeting> meetingList = null;

    // Key - pk / Value - name(value)
    private Map<String, String> professorList = null;
    private Map<String, String> techniqueList = null;


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
        this.isCapstone = collaboRequest.getIsCapstone();

        if (collaboRequest.getProjectId() != null) {
            this.projectId = String.valueOf(collaboRequest.getProjectId().getProjectId());
        }

        if (collaboRequest.getMeetingList() != null) {
            this.meetingList = collaboRequest.getMeetingList();
        }

        if (collaboRequest.getCollaboRequestProfessorList() != null) {
            collaboRequestProfessorList = collaboRequest.getCollaboRequestProfessorList();
            professorList = new HashMap<>();
            List<CollaboRequestProfessor> requestProfessors = collaboRequest.getCollaboRequestProfessorList();
            for (CollaboRequestProfessor e : requestProfessors) {
                professorList.put(String.valueOf(e.getProfessor().getAccountId()), e.getProfessor().getName());
            }
        }

        if (collaboRequest.getCollaboRequestTechniqueList() != null) {
            collaboRequestTechniqueList = collaboRequest.getCollaboRequestTechniqueList();
            techniqueList = new HashMap<>();
            List<CollaboRequestTechnique> requestTechniques = collaboRequest.getCollaboRequestTechniqueList();
            for (CollaboRequestTechnique e : requestTechniques) {
                techniqueList.put(String.valueOf(e.getFieldCategory().getFieldCategoryId()), e.getFieldCategory().getCategoryName());
            }
        }
    }
}
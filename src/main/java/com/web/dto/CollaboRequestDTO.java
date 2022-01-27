package com.web.dto;


import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.meeting.Meeting;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private String termType;
    private String expireDate;
    private String description;
    private String status;
    private String requestType;
    private String budget;
    private String isCapstone;

    // nullable true column list
    private String projectId = null;

    // presentation layer 에서 사용되지 않는 정보
    private List<CollaboRequestProfessorDTO> collaboRequestProfessorList = null;
    private List<CollaboRequestTechniqueDTO> collaboRequestTechniqueList = null;
    private List<MeetingDTO> meetingList = null;


    public CollaboRequestDTO(CollaboRequest collaboRequest) {

        this.collaboRequestId = String.valueOf(collaboRequest.getCollaboRequestId());
        this.officerId = String.valueOf(collaboRequest.getOfficer().getAccountId());
        this.officerName = collaboRequest.getOfficer().getName();
        this.companyId = String.valueOf(collaboRequest.getCompany().getAccountId());
        this.companyName = collaboRequest.getCompany().getName();
        this.title = collaboRequest.getTitle();
        this.term = collaboRequest.getTerm();
        this.termType = collaboRequest.getTermType();
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
            this.meetingList = collaboRequest.getMeetingList().stream().map(MeetingDTO::new).collect(Collectors.toList());
        }

        if (collaboRequest.getCollaboRequestProfessorList() != null) {
            this.collaboRequestProfessorList = collaboRequest.getCollaboRequestProfessorList().stream().map(CollaboRequestProfessorDTO::new).collect(Collectors.toList());
        }

        if (collaboRequest.getCollaboRequestTechniqueList() != null) {
            this.collaboRequestTechniqueList = collaboRequest.getCollaboRequestTechniqueList().stream().map(CollaboRequestTechniqueDTO::new).collect(Collectors.toList());
        }
    }
}

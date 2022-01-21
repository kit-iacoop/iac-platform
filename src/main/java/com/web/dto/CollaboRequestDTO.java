package com.web.dto;


import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.meeting.Meeting;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CollaboRequestDTO {

    // not null column list
    private String collaboRequestId;
    private String officerId;
    private String companyId;
    private String title;
    private String term;
    private String expireDate;
    private String description;
    private String status;
    private String requestType;
    private String budget;

    // nullable true column list
    private String projectId;

    private List<CollaboRequestProfessor> collaboRequestProfessorList;
    private List<CollaboRequestTechnique> collaboRequestTechniqueList;

    private List<Meeting> meetingList;
}

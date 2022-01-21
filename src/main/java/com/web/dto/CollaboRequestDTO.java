package com.web.dto;


import com.domain.meeting.Meeting;
import lombok.*;

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
}

package com.web.dto;

import com.domain.account.Account;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.meetingFile.MeetingFile;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDTO {
    private String meetingId;

    private String collaboRequestId;

    private String projectId;
    private String meetingLocation;
    private String meetingName;
    private String meetingDate;
    private String meetingTime;
    private String meetingType;

    private List<MeetingAttendantDTO> meetingAttendantList;
    private List<MeetingFileDTO> meetingFileList;
    
}

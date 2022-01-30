package com.web.dto;

import com.domain.account.Account;
import com.domain.meeting.Meeting;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.meetingFile.MeetingFile;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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

    public MeetingDTO(Meeting meeting) {
        this.meetingId = String.valueOf(meeting.getMeetingId());
        this.collaboRequestId = String.valueOf(meeting.getCollaboRequest().getCollaboRequestId());
        this.projectId = String.valueOf(meeting.getProject().getProjectId());
        this.meetingLocation = meeting.getMeetingLocation();
        this.meetingName = meeting.getMeetingName();
        this.meetingDate = String.valueOf(meeting.getMeetingDate());
        this.meetingTime = meeting.getMeetingTime();
        this.meetingType = meeting.getMeetingType();

        this.meetingAttendantList = meeting.getMeetingAttendantList().stream().map(MeetingAttendantDTO::new).collect(Collectors.toList());
        this.meetingFileList = meeting.getMeetingFileList().stream().map(MeetingFileDTO::new).collect(Collectors.toList());
    }
}
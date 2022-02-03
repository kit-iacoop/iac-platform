package com.web.dto;

import com.domain.account.Account;
import com.domain.meeting.Meeting;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.security.role.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingAttendantDTO {
    private String meetingAttendantId;
    private String meetingId;
    private String accountId;
    private String accountName;
    private String RoleName;

    public MeetingAttendantDTO(MeetingAttendant meetingAttendant) {
        this.meetingAttendantId = String.valueOf(meetingAttendant.getMeetingAttendantId());
        this.meetingId = String.valueOf(meetingAttendant.getMeeting().getMeetingId());
        this.accountId = String.valueOf(meetingAttendant.getAccount().getAccountId());
        this.accountName = meetingAttendant.getAccount().getName();

        for (Role role : meetingAttendant.getAccount().getAccountRoles()) {
            String roleName = role.getRoleName();
            switch (roleName) {
                case "ROLE_PROFESSOR":
                    RoleName = "ROLE_PROFESSOR";
                    break;
                case "ROLE_COMPANY":
                    RoleName = "ROLE_COMPANY";
                    break;
                case "ROLE_STUDENT":
                    RoleName = "ROLE_STUDENT";
                    break;
                default:
                    RoleName = "UNKNOWN";
                    break;
            }
        }
    }
}
package com.web.dto;

import lombok.*;

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
    private String accountDept; // 해당 참여자의 소속
    private String accountRole; // 기업인지, 교수인지, 학생인지 등 표시
}

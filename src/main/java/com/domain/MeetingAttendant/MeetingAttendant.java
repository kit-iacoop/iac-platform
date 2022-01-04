package com.domain.MeetingAttendant;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MEETING_ATTENDANT")
public class MeetingAttendant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ATTENDANT_ID", nullable = false)
    private Long meetingAttendantId;

    @Column(name = "MEETING_ID", nullable = false)
    private Long meetingId;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;


}

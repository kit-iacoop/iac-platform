package com.domain.meetingAttendant;

import com.domain.account.Account;
import com.domain.meeting.Meeting;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@SuperBuilder
@Entity
@Table(name = "MEETING_ATTENDANT")
public class MeetingAttendant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ATTENDANT_ID", nullable = false)
    private Long meetingAttendantId;

    @ManyToOne
    @JoinColumn(name = "MEETING_ID", nullable = false)
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    public void setMeeting(Meeting meetingId) {
        if (this.meeting != null) {
            this.meeting.getMeetingAttendantList().remove(this);
        }
        this.meeting = meetingId;
        meetingId.getMeetingAttendantList().add(this);
    }

    public void setAccount(Account accountId) {
        if (this.account != null) {
            this.account.getMeetingAttendantList().remove(this);
        }
        this.account = accountId;
        accountId.getMeetingAttendantList().add(this);
    }
}

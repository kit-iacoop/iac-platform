package com.domain.MeetingAttendant;

import com.domain.Account.Account;
import com.domain.Meeting.Meeting;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
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

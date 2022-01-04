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
    private Meeting meetingId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account accountId;

    public void setMeeting(Meeting meetingId) {
        if (this.meetingId != null) {
            this.meetingId.getMeetingAttendantList().remove(this);
        }
        this.meetingId = meetingId;
        meetingId.getMeetingAttendantList().add(this);
    }

    public void setAccount(Account accountId) {
        if (this.accountId != null) {
            this.accountId.getMeetingAttendantList().remove(this);
        }
        this.accountId = accountId;
        accountId.getMeetingAttendantList().add(this);
    }
}

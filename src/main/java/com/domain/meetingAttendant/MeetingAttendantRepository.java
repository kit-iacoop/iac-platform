package com.domain.meetingAttendant;

import com.domain.account.Account;
import com.domain.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingAttendantRepository extends JpaRepository<MeetingAttendant, Long> {

    List<MeetingAttendant> findByMeeting(Meeting meeting);

    List<MeetingAttendant> findByAccount(Account account);
}

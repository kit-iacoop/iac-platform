package com.domain.MeetingAttendant;

import com.domain.Account.Account;
import com.domain.Meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingAttendantRepository extends JpaRepository<MeetingAttendant, Long> {

    List<MeetingAttendant> findByMeeting(Meeting meeting);

    List<MeetingAttendant> findByAccount(Account account);
}

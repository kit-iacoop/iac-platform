package com.domain.meetingFile;

import com.domain.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingFileRepository extends JpaRepository<MeetingFile, Long> {

    List<MeetingFile> findByMeeting(Meeting meeting);
}

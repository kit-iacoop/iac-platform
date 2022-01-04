package com.domain.MeetingFile;

import com.domain.Meeting.Meeting;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MEETING_FILE")
public class MeetingFile extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_FILE_ID", nullable = false)
    private Long meetingFileId;

    @ManyToOne
    @JoinColumn(name = "MEETING_ID", nullable = false)
    private Meeting meetingId;

    @Column(name = "FILE_TYPE", nullable = false)
    private String fileType;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false)
    private String filePath;

    @Column(name = "FILE_SIZE", nullable = false)
    private String fileSize;

    public void setMeetingId(Meeting meetingId) {
        if (this.meetingId != null) {
            this.meetingId.getMeetingFileList().remove(this);
        }
        this.meetingId = meetingId;
        meetingId.getMeetingFileList().add(this);
    }
}

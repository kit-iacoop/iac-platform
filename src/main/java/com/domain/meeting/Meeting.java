package com.domain.meeting;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.meetingFile.MeetingFile;
import com.domain.project.Project;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder
@Entity
@Table(name = "MEETING")
public class Meeting extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID", nullable = false)
    private Long meetingId;

    @ManyToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequest;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "MEETING_LOCATION", nullable = false)
    private String meetingLocation;

    @Column(name = "MEETING_NAME", nullable = false)
    private String meetingName;

    @Column(name = "MEETING_DATE", nullable = false)
    private LocalDate meetingDate;

    @Column(name = "MEETING_TIME", nullable = false)
    private String meetingTime;

    // TODO: enum써야할지 고민중
    @Column(name = "MEETING_TYPE", nullable = false)
    private String meetingType;

    @OneToMany(mappedBy = "meeting")
    List<MeetingAttendant> meetingAttendantList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting")
    List<MeetingFile> meetingFileList = new ArrayList<>();

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequest != null) {
            this.collaboRequest.getMeetingList().remove(this);
        }
        this.collaboRequest = collaboRequestId;
        collaboRequestId.getMeetingList().add(this);
    }

    public void setProject(Project projectId) {
        if (this.project != null) {
            this.project.getMeetingList().remove(this);
        }
        this.project = projectId;
        projectId.getMeetingList().add(this);
    }
}

package com.domain.Meeting;

import com.domain.CollaboRequest.CollaboRequest;
import com.domain.MeetingAttendant.MeetingAttendant;
import com.domain.MeetingFile.MeetingFile;
import com.domain.Project.Project;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MEETING")
public class Meeting extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID", nullable = false)
    private Long meetingId;

    @ManyToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequestId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project projectId;

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

    @OneToMany(mappedBy = "meetingId")
    List<MeetingAttendant> meetingAttendantList = new ArrayList<>();

    @OneToMany(mappedBy = "meetingId")
    List<MeetingFile> meetingFileList = new ArrayList<>();

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequestId != null) {
            this.collaboRequestId.getMeetingList().remove(this);
        }
        this.collaboRequestId = collaboRequestId;
        collaboRequestId.getMeetingList().add(this);
    }

    public void setProject(Project projectId) {
        if (this.projectId != null) {
            this.projectId.getMeetingList().remove(this);
        }
        this.projectId = projectId;
        projectId.getMeetingList().add(this);
    }
}

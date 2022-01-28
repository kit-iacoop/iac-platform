package com.qdomain.meeting;

import com.domain.meeting.Meeting;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.meetingFile.QMeetingFile;
import com.qdomain.project.QProject;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMeeting is a Querydsl query type for Meeting
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeeting extends EntityPathBase<Meeting> {

    private static final long serialVersionUID = -160013493L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeeting meeting = new QMeeting("meeting");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCollaboRequest collaboRequest;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ListPath<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant> meetingAttendantList = this.<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant>createList("meetingAttendantList", com.domain.meetingAttendant.MeetingAttendant.class, QMeetingAttendant.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> meetingDate = createDate("meetingDate", java.time.LocalDate.class);

    public final ListPath<com.domain.meetingFile.MeetingFile, QMeetingFile> meetingFileList = this.<com.domain.meetingFile.MeetingFile, QMeetingFile>createList("meetingFileList", com.domain.meetingFile.MeetingFile.class, QMeetingFile.class, PathInits.DIRECT2);

    public final NumberPath<Long> meetingId = createNumber("meetingId", Long.class);

    public final StringPath meetingLocation = createString("meetingLocation");

    public final StringPath meetingName = createString("meetingName");

    public final StringPath meetingTime = createString("meetingTime");

    public final StringPath meetingType = createString("meetingType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProject project;

    public QMeeting(String variable) {
        this(Meeting.class, forVariable(variable), INITS);
    }

    public QMeeting(Path<? extends Meeting> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeeting(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeeting(PathMetadata metadata, PathInits inits) {
        this(Meeting.class, metadata, inits);
    }

    public QMeeting(Class<? extends Meeting> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.collaboRequest = inits.isInitialized("collaboRequest") ? new QCollaboRequest(forProperty("collaboRequest"), inits.get("collaboRequest")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}


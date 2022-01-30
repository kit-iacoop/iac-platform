package com.qdomain.meetingFile;

import com.domain.meetingFile.MeetingFile;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.meeting.QMeeting;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMeetingFile is a Querydsl query type for MeetingFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeetingFile extends EntityPathBase<MeetingFile> {

    private static final long serialVersionUID = -1854877693L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeetingFile meetingFile = new QMeetingFile("meetingFile");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileSize = createString("fileSize");

    public final StringPath fileType = createString("fileType");

    public final QMeeting meeting;

    public final NumberPath<Long> meetingFileId = createNumber("meetingFileId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMeetingFile(String variable) {
        this(MeetingFile.class, forVariable(variable), INITS);
    }

    public QMeetingFile(Path<? extends MeetingFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeetingFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeetingFile(PathMetadata metadata, PathInits inits) {
        this(MeetingFile.class, metadata, inits);
    }

    public QMeetingFile(Class<? extends MeetingFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.meeting = inits.isInitialized("meeting") ? new QMeeting(forProperty("meeting"), inits.get("meeting")) : null;
    }

}


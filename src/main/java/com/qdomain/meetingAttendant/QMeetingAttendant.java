package com.qdomain.meetingAttendant;

import com.domain.meetingAttendant.MeetingAttendant;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QAccount;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.meeting.QMeeting;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMeetingAttendant is a Querydsl query type for MeetingAttendant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeetingAttendant extends EntityPathBase<MeetingAttendant> {

    private static final long serialVersionUID = 92581297L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeetingAttendant meetingAttendant = new QMeetingAttendant("meetingAttendant");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QMeeting meeting;

    public final NumberPath<Long> meetingAttendantId = createNumber("meetingAttendantId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMeetingAttendant(String variable) {
        this(MeetingAttendant.class, forVariable(variable), INITS);
    }

    public QMeetingAttendant(Path<? extends MeetingAttendant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeetingAttendant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeetingAttendant(PathMetadata metadata, PathInits inits) {
        this(MeetingAttendant.class, metadata, inits);
    }

    public QMeetingAttendant(Class<? extends MeetingAttendant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
        this.meeting = inits.isInitialized("meeting") ? new QMeeting(forProperty("meeting"), inits.get("meeting")) : null;
    }

}


package com.qdomain.participantCopyright;

import com.domain.participantCopyright.ParticipantCopyright;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;
import com.qdomain.account.QStudent;
import com.qdomain.copyright.QCopyright;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QParticipantCopyright is a Querydsl query type for ParticipantCopyright
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParticipantCopyright extends EntityPathBase<ParticipantCopyright> {

    private static final long serialVersionUID = -692573711L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParticipantCopyright participantCopyright = new QParticipantCopyright("participantCopyright");

    public final QCopyright copyright;

    public final NumberPath<Long> participantCopyrightId = createNumber("participantCopyrightId", Long.class);

    public final StringPath ratio = createString("ratio");

    public final QStudent student;

    public QParticipantCopyright(String variable) {
        this(ParticipantCopyright.class, forVariable(variable), INITS);
    }

    public QParticipantCopyright(Path<? extends ParticipantCopyright> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParticipantCopyright(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParticipantCopyright(PathMetadata metadata, PathInits inits) {
        this(ParticipantCopyright.class, metadata, inits);
    }

    public QParticipantCopyright(Class<? extends ParticipantCopyright> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.copyright = inits.isInitialized("copyright") ? new QCopyright(forProperty("copyright"), inits.get("copyright")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}


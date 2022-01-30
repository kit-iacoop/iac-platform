package com.qdomain.copyright;

import com.domain.copyright.Copyright;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QAccount;
import com.qdomain.applicationRegistration.QApplicationRegistration;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.participantCopyright.QParticipantCopyright;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCopyright is a Querydsl query type for Copyright
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCopyright extends EntityPathBase<Copyright> {

    private static final long serialVersionUID = 1156609699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCopyright copyright = new QCopyright("copyright");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QAccount accountId;

    public final ListPath<com.domain.applicationRegistration.ApplicationRegistration, QApplicationRegistration> applicationRegistrationList = this.<com.domain.applicationRegistration.ApplicationRegistration, QApplicationRegistration>createList("applicationRegistrationList", com.domain.applicationRegistration.ApplicationRegistration.class, QApplicationRegistration.class, PathInits.DIRECT2);

    public final StringPath cooperation = createString("cooperation");

    public final NumberPath<Long> copyrightId = createNumber("copyrightId", Long.class);

    public final EnumPath<com.domain.common.CopyrightType> copyrightType = createEnum("copyrightType", com.domain.common.CopyrightType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath declarationYear = createString("declarationYear");

    public final StringPath description = createString("description");

    public final StringPath keyword = createString("keyword");

    public final StringPath maintenanceState = createString("maintenanceState");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final ListPath<com.domain.participantCopyright.ParticipantCopyright, QParticipantCopyright> participantCopyrightList = this.<com.domain.participantCopyright.ParticipantCopyright, QParticipantCopyright>createList("participantCopyrightList", com.domain.participantCopyright.ParticipantCopyright.class, QParticipantCopyright.class, PathInits.DIRECT2);

    public final StringPath professorDepartment = createString("professorDepartment");

    public final StringPath professorName = createString("professorName");

    public final NumberPath<Integer> professorRatio = createNumber("professorRatio", Integer.class);

    public final StringPath representor = createString("representor");

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    public QCopyright(String variable) {
        this(Copyright.class, forVariable(variable), INITS);
    }

    public QCopyright(Path<? extends Copyright> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCopyright(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCopyright(PathMetadata metadata, PathInits inits) {
        this(Copyright.class, metadata, inits);
    }

    public QCopyright(Class<? extends Copyright> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountId = inits.isInitialized("accountId") ? new QAccount(forProperty("accountId"), inits.get("accountId")) : null;
    }

}


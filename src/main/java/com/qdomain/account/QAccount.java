package com.qdomain.account;

import com.domain.account.Account;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QAddress;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.copyright.QCopyright;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.security.role.QRole;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -53292753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final SetPath<com.domain.security.role.Role, QRole> accountRoles = this.<com.domain.security.role.Role, QRole>createSet("accountRoles", com.domain.security.role.Role.class, QRole.class, PathInits.DIRECT2);

    public final QAddress address;

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final ListPath<com.domain.copyright.Copyright, QCopyright> copyrightList = this.<com.domain.copyright.Copyright, QCopyright>createList("copyrightList", com.domain.copyright.Copyright.class, QCopyright.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final StringPath loginId = createString("loginId");

    public final ListPath<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant> meetingAttendantList = this.<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant>createList("meetingAttendantList", com.domain.meetingAttendant.MeetingAttendant.class, QMeetingAttendant.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<com.domain.common.State> status = createEnum("status", com.domain.common.State.class);

    public final StringPath telephone = createString("telephone");

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
    }

}


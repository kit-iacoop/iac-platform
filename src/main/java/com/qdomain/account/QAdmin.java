package com.qdomain.account;

import com.domain.account.Admin;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QAddress;
import com.qdomain.copyright.QCopyright;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.security.role.QRole;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = 1448026833L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdmin admin = new QAdmin("admin");

    public final QAccount _super;

    //inherited
    public final NumberPath<Long> accountId;

    //inherited
    public final SetPath<com.domain.security.role.Role, QRole> accountRoles;

    // inherited
    public final QAddress address;

    //inherited
    public final DatePath<java.time.LocalDate> birthDate;

    //inherited
    public final ListPath<com.domain.copyright.Copyright, QCopyright> copyrightList;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    //inherited
    public final StringPath email;

    //inherited
    public final StringPath loginId;

    //inherited
    public final ListPath<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant> meetingAttendantList;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    //inherited
    public final StringPath name;

    //inherited
    public final StringPath password;

    //inherited
    public final EnumPath<com.domain.common.State> status;

    //inherited
    public final StringPath telephone;

    public QAdmin(String variable) {
        this(Admin.class, forVariable(variable), INITS);
    }

    public QAdmin(Path<? extends Admin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdmin(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdmin(PathMetadata metadata, PathInits inits) {
        this(Admin.class, metadata, inits);
    }

    public QAdmin(Class<? extends Admin> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAccount(type, metadata, inits);
        this.accountId = _super.accountId;
        this.accountRoles = _super.accountRoles;
        this.address = _super.address;
        this.birthDate = _super.birthDate;
        this.copyrightList = _super.copyrightList;
        this.createdDate = _super.createdDate;
        this.email = _super.email;
        this.loginId = _super.loginId;
        this.meetingAttendantList = _super.meetingAttendantList;
        this.modifiedDate = _super.modifiedDate;
        this.name = _super.name;
        this.password = _super.password;
        this.status = _super.status;
        this.telephone = _super.telephone;
    }

}


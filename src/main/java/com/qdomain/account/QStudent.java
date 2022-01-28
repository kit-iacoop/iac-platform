package com.qdomain.account;

import com.domain.account.Student;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QAddress;
import com.qdomain.copyright.QCopyright;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.security.role.QRole;
import com.qdomain.university.QUniversity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = -755119811L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

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

    public final StringPath department = createString("department");

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

    public final NumberPath<Long> studentNumber = createNumber("studentNumber", Long.class);

    //inherited
    public final StringPath telephone;

    public final QUniversity university;

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
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
        this.university = inits.isInitialized("university") ? new QUniversity(forProperty("university"), inits.get("university")) : null;
    }

}


package com.qdomain.account;

import com.domain.account.Company;
import com.domain.account.Professor;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.collaboRequestProfessor.QCollaboRequestProfessor;
import com.qdomain.common.QAddress;
import com.qdomain.copyright.QCopyright;
import com.qdomain.fieldInterest.QFieldInterest;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.projectProfessor.QProjectProfessor;
import com.qdomain.security.role.QRole;
import com.qdomain.university.QUniversity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProfessor is a Querydsl query type for Professor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfessor extends EntityPathBase<Professor> {

    private static final long serialVersionUID = 1143432433L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfessor professor = new QProfessor("professor");

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

    public final ListPath<com.domain.fieldInterest.FieldInterest, QFieldInterest> interestedFieldList = this.<com.domain.fieldInterest.FieldInterest, QFieldInterest>createList("interestedFieldList", com.domain.fieldInterest.FieldInterest.class, QFieldInterest.class, PathInits.DIRECT2);

    //inherited
    public final StringPath loginId;

    //inherited
    public final ListPath<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant> meetingAttendantList;

    public final ListPath<Company, QCompany> menteeCompanyList = this.<Company, QCompany>createList("menteeCompanyList", Company.class, QCompany.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    //inherited
    public final StringPath name;

    public final StringPath officeLocation = createString("officeLocation");

    //inherited
    public final StringPath password;

    public final ListPath<com.domain.projectProfessor.ProjectProfessor, QProjectProfessor> projectList = this.<com.domain.projectProfessor.ProjectProfessor, QProjectProfessor>createList("projectList", com.domain.projectProfessor.ProjectProfessor.class, QProjectProfessor.class, PathInits.DIRECT2);

    public final ListPath<com.domain.collaboRequestProfessor.CollaboRequestProfessor, QCollaboRequestProfessor> requestProjectList = this.<com.domain.collaboRequestProfessor.CollaboRequestProfessor, QCollaboRequestProfessor>createList("requestProjectList", com.domain.collaboRequestProfessor.CollaboRequestProfessor.class, QCollaboRequestProfessor.class, PathInits.DIRECT2);

    //inherited
    public final EnumPath<com.domain.common.State> status;

    //inherited
    public final StringPath telephone;

    public final QUniversity university;

    public QProfessor(String variable) {
        this(Professor.class, forVariable(variable), INITS);
    }

    public QProfessor(Path<? extends Professor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfessor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfessor(PathMetadata metadata, PathInits inits) {
        this(Professor.class, metadata, inits);
    }

    public QProfessor(Class<? extends Professor> type, PathMetadata metadata, PathInits inits) {
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


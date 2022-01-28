package com.qdomain.account;

import com.domain.account.Officer;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.annualFee.QAnnualFee;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QAddress;
import com.qdomain.copyright.QCopyright;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.mileageRequest.QMileageRequest;
import com.qdomain.security.role.QRole;
import com.qdomain.university.QUniversity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QOfficer is a Querydsl query type for Officer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOfficer extends EntityPathBase<Officer> {

    private static final long serialVersionUID = -424681416L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOfficer officer = new QOfficer("officer");

    public final QAccount _super;

    //inherited
    public final NumberPath<Long> accountId;

    //inherited
    public final SetPath<com.domain.security.role.Role, QRole> accountRoles;

    // inherited
    public final QAddress address;

    public final ListPath<com.domain.annualFee.AnnualFee, QAnnualFee> annualFee = this.<com.domain.annualFee.AnnualFee, QAnnualFee>createList("annualFee", com.domain.annualFee.AnnualFee.class, QAnnualFee.class, PathInits.DIRECT2);

    //inherited
    public final DatePath<java.time.LocalDate> birthDate;

    public final ListPath<com.domain.collaboRequest.CollaboRequest, QCollaboRequest> collaboRequest = this.<com.domain.collaboRequest.CollaboRequest, QCollaboRequest>createList("collaboRequest", com.domain.collaboRequest.CollaboRequest.class, QCollaboRequest.class, PathInits.DIRECT2);

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

    public final ListPath<com.domain.mileageRequest.MileageRequest, QMileageRequest> mileageRequest = this.<com.domain.mileageRequest.MileageRequest, QMileageRequest>createList("mileageRequest", com.domain.mileageRequest.MileageRequest.class, QMileageRequest.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    //inherited
    public final StringPath name;

    public final StringPath officeLocation = createString("officeLocation");

    //inherited
    public final StringPath password;

    //inherited
    public final EnumPath<com.domain.common.State> status;

    //inherited
    public final StringPath telephone;

    public final QUniversity university;

    public QOfficer(String variable) {
        this(Officer.class, forVariable(variable), INITS);
    }

    public QOfficer(Path<? extends Officer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOfficer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOfficer(PathMetadata metadata, PathInits inits) {
        this(Officer.class, metadata, inits);
    }

    public QOfficer(Class<? extends Officer> type, PathMetadata metadata, PathInits inits) {
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


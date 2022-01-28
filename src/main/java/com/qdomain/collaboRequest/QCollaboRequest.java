package com.qdomain.collaboRequest;

import com.domain.collaboRequest.CollaboRequest;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QCompany;
import com.qdomain.account.QOfficer;
import com.qdomain.collaboRequestProfessor.QCollaboRequestProfessor;
import com.qdomain.collaboRequestTechnique.QCollaboRequestTechnique;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.meeting.QMeeting;
import com.qdomain.project.QProject;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCollaboRequest is a Querydsl query type for CollaboRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollaboRequest extends EntityPathBase<CollaboRequest> {

    private static final long serialVersionUID = -1673089839L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCollaboRequest collaboRequest = new QCollaboRequest("collaboRequest");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> collaboRequestId = createNumber("collaboRequestId", Long.class);

    public final ListPath<com.domain.collaboRequestProfessor.CollaboRequestProfessor, QCollaboRequestProfessor> collaboRequestProfessorList = this.<com.domain.collaboRequestProfessor.CollaboRequestProfessor, QCollaboRequestProfessor>createList("collaboRequestProfessorList", com.domain.collaboRequestProfessor.CollaboRequestProfessor.class, QCollaboRequestProfessor.class, PathInits.DIRECT2);

    public final ListPath<com.domain.collaboRequestTechnique.CollaboRequestTechnique, QCollaboRequestTechnique> collaboRequestTechniqueList = this.<com.domain.collaboRequestTechnique.CollaboRequestTechnique, QCollaboRequestTechnique>createList("collaboRequestTechniqueList", com.domain.collaboRequestTechnique.CollaboRequestTechnique.class, QCollaboRequestTechnique.class, PathInits.DIRECT2);

    public final QCompany company;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final DatePath<java.time.LocalDate> expireDate = createDate("expireDate", java.time.LocalDate.class);

    public final ListPath<com.domain.meeting.Meeting, QMeeting> meetingList = this.<com.domain.meeting.Meeting, QMeeting>createList("meetingList", com.domain.meeting.Meeting.class, QMeeting.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QOfficer officer;

    public final QProject projectId;

    public final EnumPath<com.domain.common.RequestType> requestType = createEnum("requestType", com.domain.common.RequestType.class);

    public final EnumPath<com.domain.common.State> status = createEnum("status", com.domain.common.State.class);

    public final StringPath term = createString("term");

    public final StringPath title = createString("title");

    public QCollaboRequest(String variable) {
        this(CollaboRequest.class, forVariable(variable), INITS);
    }

    public QCollaboRequest(Path<? extends CollaboRequest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCollaboRequest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCollaboRequest(PathMetadata metadata, PathInits inits) {
        this(CollaboRequest.class, metadata, inits);
    }

    public QCollaboRequest(Class<? extends CollaboRequest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.officer = inits.isInitialized("officer") ? new QOfficer(forProperty("officer"), inits.get("officer")) : null;
        this.projectId = inits.isInitialized("projectId") ? new QProject(forProperty("projectId"), inits.get("projectId")) : null;
    }

}


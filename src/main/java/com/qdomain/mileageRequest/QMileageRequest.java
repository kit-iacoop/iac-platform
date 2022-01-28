package com.qdomain.mileageRequest;

import com.domain.mileageRequest.MileageRequest;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QCompany;
import com.qdomain.account.QOfficer;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.companyMileage.QCompanyMileage;
import com.qdomain.mileageFile.QMileageFile;
import com.qdomain.mileagePolicy.QMileagePolicy;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMileageRequest is a Querydsl query type for MileageRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMileageRequest extends EntityPathBase<MileageRequest> {

    private static final long serialVersionUID = -1920518703L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMileageRequest mileageRequest = new QMileageRequest("mileageRequest");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> achievementCnt = createNumber("achievementCnt", Long.class);

    public final QCompany company;

    public final QCompanyMileage companyMileage;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final ListPath<com.domain.mileageFile.MileageFile, QMileageFile> mileageFileList = this.<com.domain.mileageFile.MileageFile, QMileageFile>createList("mileageFileList", com.domain.mileageFile.MileageFile.class, QMileageFile.class, PathInits.DIRECT2);

    public final QMileagePolicy mileagePolicy;

    public final NumberPath<Long> mileageRequestId = createNumber("mileageRequestId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QOfficer officer;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public final EnumPath<com.domain.common.State> status = createEnum("status", com.domain.common.State.class);

    public QMileageRequest(String variable) {
        this(MileageRequest.class, forVariable(variable), INITS);
    }

    public QMileageRequest(Path<? extends MileageRequest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMileageRequest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMileageRequest(PathMetadata metadata, PathInits inits) {
        this(MileageRequest.class, metadata, inits);
    }

    public QMileageRequest(Class<? extends MileageRequest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.companyMileage = inits.isInitialized("companyMileage") ? new QCompanyMileage(forProperty("companyMileage"), inits.get("companyMileage")) : null;
        this.mileagePolicy = inits.isInitialized("mileagePolicy") ? new QMileagePolicy(forProperty("mileagePolicy"), inits.get("mileagePolicy")) : null;
        this.officer = inits.isInitialized("officer") ? new QOfficer(forProperty("officer"), inits.get("officer")) : null;
    }

}


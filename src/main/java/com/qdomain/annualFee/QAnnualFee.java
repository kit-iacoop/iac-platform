package com.qdomain.annualFee;

import com.domain.annualFee.AnnualFee;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QCompany;
import com.qdomain.account.QOfficer;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.gradePolicy.QGradePolicy;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAnnualFee is a Querydsl query type for AnnualFee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnualFee extends EntityPathBase<AnnualFee> {

    private static final long serialVersionUID = -635561629L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnualFee annualFee = new QAnnualFee("annualFee");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> annualFeeId = createNumber("annualFeeId", Long.class);

    public final NumberPath<Long> cash = createNumber("cash", Long.class);

    public final QCompany company;

    public final DatePath<java.time.LocalDate> confirmDate = createDate("confirmDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QGradePolicy gradePolicy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QOfficer officer;

    public final EnumPath<com.domain.common.State> paymentStatus = createEnum("paymentStatus", com.domain.common.State.class);

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QAnnualFee(String variable) {
        this(AnnualFee.class, forVariable(variable), INITS);
    }

    public QAnnualFee(Path<? extends AnnualFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnualFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnualFee(PathMetadata metadata, PathInits inits) {
        this(AnnualFee.class, metadata, inits);
    }

    public QAnnualFee(Class<? extends AnnualFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.gradePolicy = inits.isInitialized("gradePolicy") ? new QGradePolicy(forProperty("gradePolicy")) : null;
        this.officer = inits.isInitialized("officer") ? new QOfficer(forProperty("officer"), inits.get("officer")) : null;
    }

}


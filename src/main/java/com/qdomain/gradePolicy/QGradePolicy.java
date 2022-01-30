package com.qdomain.gradePolicy;

import com.domain.gradePolicy.GradePolicy;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.annualFee.QAnnualFee;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QGradePolicy is a Querydsl query type for GradePolicy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGradePolicy extends EntityPathBase<GradePolicy> {

    private static final long serialVersionUID = -2077855705L;

    public static final QGradePolicy gradePolicy = new QGradePolicy("gradePolicy");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final ListPath<com.domain.annualFee.AnnualFee, QAnnualFee> annualFee = this.<com.domain.annualFee.AnnualFee, QAnnualFee>createList("annualFee", com.domain.annualFee.AnnualFee.class, QAnnualFee.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath grade = createString("grade");

    public final NumberPath<Long> gradePolicyId = createNumber("gradePolicyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public QGradePolicy(String variable) {
        super(GradePolicy.class, forVariable(variable));
    }

    public QGradePolicy(Path<? extends GradePolicy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGradePolicy(PathMetadata metadata) {
        super(GradePolicy.class, metadata);
    }

}


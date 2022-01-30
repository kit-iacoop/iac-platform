package com.qdomain.mileagePolicy;

import com.domain.mileagePolicy.MileagePolicy;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.collaborationCategory.QCollaborationCategory;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMileagePolicy is a Querydsl query type for MileagePolicy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMileagePolicy extends EntityPathBase<MileagePolicy> {

    private static final long serialVersionUID = -1289690099L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMileagePolicy mileagePolicy = new QMileagePolicy("mileagePolicy");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCollaborationCategory collaborationCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath inOrOut = createString("inOrOut");

    public final NumberPath<Long> mileage = createNumber("mileage", Long.class);

    public final NumberPath<Long> mileagePolicyId = createNumber("mileagePolicyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public QMileagePolicy(String variable) {
        this(MileagePolicy.class, forVariable(variable), INITS);
    }

    public QMileagePolicy(Path<? extends MileagePolicy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMileagePolicy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMileagePolicy(PathMetadata metadata, PathInits inits) {
        this(MileagePolicy.class, metadata, inits);
    }

    public QMileagePolicy(Class<? extends MileagePolicy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.collaborationCategory = inits.isInitialized("collaborationCategory") ? new QCollaborationCategory(forProperty("collaborationCategory"), inits.get("collaborationCategory")) : null;
    }

}


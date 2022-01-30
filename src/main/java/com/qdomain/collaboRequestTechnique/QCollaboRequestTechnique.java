package com.qdomain.collaboRequestTechnique;

import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.fieldCategory.QFieldCategory;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCollaboRequestTechnique is a Querydsl query type for CollaboRequestTechnique
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollaboRequestTechnique extends EntityPathBase<CollaboRequestTechnique> {

    private static final long serialVersionUID = -1134060005L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCollaboRequestTechnique collaboRequestTechnique = new QCollaboRequestTechnique("collaboRequestTechnique");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCollaboRequest collaboRequest;

    public final NumberPath<Long> collaboRequestTechniqueId = createNumber("collaboRequestTechniqueId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QFieldCategory fieldCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QCollaboRequestTechnique(String variable) {
        this(CollaboRequestTechnique.class, forVariable(variable), INITS);
    }

    public QCollaboRequestTechnique(Path<? extends CollaboRequestTechnique> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCollaboRequestTechnique(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCollaboRequestTechnique(PathMetadata metadata, PathInits inits) {
        this(CollaboRequestTechnique.class, metadata, inits);
    }

    public QCollaboRequestTechnique(Class<? extends CollaboRequestTechnique> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.collaboRequest = inits.isInitialized("collaboRequest") ? new QCollaboRequest(forProperty("collaboRequest"), inits.get("collaboRequest")) : null;
        this.fieldCategory = inits.isInitialized("fieldCategory") ? new QFieldCategory(forProperty("fieldCategory"), inits.get("fieldCategory")) : null;
    }

}


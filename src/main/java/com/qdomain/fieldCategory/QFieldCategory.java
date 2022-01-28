package com.qdomain.fieldCategory;

import com.domain.fieldCategory.FieldCategory;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.collaboRequestTechnique.QCollaboRequestTechnique;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.fieldInterest.QFieldInterest;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFieldCategory is a Querydsl query type for FieldCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFieldCategory extends EntityPathBase<FieldCategory> {

    private static final long serialVersionUID = -1721596411L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFieldCategory fieldCategory = new QFieldCategory("fieldCategory");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final StringPath categoryName = createString("categoryName");

    public final ListPath<com.domain.collaboRequestTechnique.CollaboRequestTechnique, QCollaboRequestTechnique> collaboRequestTechniqueList = this.<com.domain.collaboRequestTechnique.CollaboRequestTechnique, QCollaboRequestTechnique>createList("collaboRequestTechniqueList", com.domain.collaboRequestTechnique.CollaboRequestTechnique.class, QCollaboRequestTechnique.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> fieldCategoryId = createNumber("fieldCategoryId", Long.class);

    public final ListPath<com.domain.fieldInterest.FieldInterest, QFieldInterest> fieldInterestList = this.<com.domain.fieldInterest.FieldInterest, QFieldInterest>createList("fieldInterestList", com.domain.fieldInterest.FieldInterest.class, QFieldInterest.class, PathInits.DIRECT2);

    public final NumberPath<Long> level = createNumber("level", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QFieldCategory parentCategory;

    public QFieldCategory(String variable) {
        this(FieldCategory.class, forVariable(variable), INITS);
    }

    public QFieldCategory(Path<? extends FieldCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFieldCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFieldCategory(PathMetadata metadata, PathInits inits) {
        this(FieldCategory.class, metadata, inits);
    }

    public QFieldCategory(Class<? extends FieldCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentCategory = inits.isInitialized("parentCategory") ? new QFieldCategory(forProperty("parentCategory"), inits.get("parentCategory")) : null;
    }

}


package com.qdomain.fieldInterest;

import com.domain.fieldInterest.FieldInterest;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QProfessor;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.fieldCategory.QFieldCategory;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFieldInterest is a Querydsl query type for FieldInterest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFieldInterest extends EntityPathBase<FieldInterest> {

    private static final long serialVersionUID = -281993891L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFieldInterest fieldInterest = new QFieldInterest("fieldInterest");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final QFieldCategory fieldCategoryId;

    public final NumberPath<Long> fieldInterestId = createNumber("fieldInterestId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProfessor professor;

    public QFieldInterest(String variable) {
        this(FieldInterest.class, forVariable(variable), INITS);
    }

    public QFieldInterest(Path<? extends FieldInterest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFieldInterest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFieldInterest(PathMetadata metadata, PathInits inits) {
        this(FieldInterest.class, metadata, inits);
    }

    public QFieldInterest(Class<? extends FieldInterest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fieldCategoryId = inits.isInitialized("fieldCategoryId") ? new QFieldCategory(forProperty("fieldCategoryId"), inits.get("fieldCategoryId")) : null;
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
    }

}


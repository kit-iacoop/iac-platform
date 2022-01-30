package com.qdomain.collaborationCategory;

import com.domain.collaborationCategory.CollaborationCategory;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCollaborationCategory is a Querydsl query type for CollaborationCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollaborationCategory extends EntityPathBase<CollaborationCategory> {

    private static final long serialVersionUID = 1562663003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCollaborationCategory collaborationCategory = new QCollaborationCategory("collaborationCategory");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> collaborationCategoryId = createNumber("collaborationCategoryId", Long.class);

    public final StringPath collaborationName = createString("collaborationName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QCollaborationCategory parentCategory;

    public QCollaborationCategory(String variable) {
        this(CollaborationCategory.class, forVariable(variable), INITS);
    }

    public QCollaborationCategory(Path<? extends CollaborationCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCollaborationCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCollaborationCategory(PathMetadata metadata, PathInits inits) {
        this(CollaborationCategory.class, metadata, inits);
    }

    public QCollaborationCategory(Class<? extends CollaborationCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentCategory = inits.isInitialized("parentCategory") ? new QCollaborationCategory(forProperty("parentCategory"), inits.get("parentCategory")) : null;
    }

}


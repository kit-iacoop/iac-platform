package com.qdomain.collaboRequestProfessor;

import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QProfessor;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCollaboRequestProfessor is a Querydsl query type for CollaboRequestProfessor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollaboRequestProfessor extends EntityPathBase<CollaboRequestProfessor> {

    private static final long serialVersionUID = 665432409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCollaboRequestProfessor collaboRequestProfessor = new QCollaboRequestProfessor("collaboRequestProfessor");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCollaboRequest collaboRequest;

    public final NumberPath<Long> collaboRequestProfessorId = createNumber("collaboRequestProfessorId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProfessor professor;

    public QCollaboRequestProfessor(String variable) {
        this(CollaboRequestProfessor.class, forVariable(variable), INITS);
    }

    public QCollaboRequestProfessor(Path<? extends CollaboRequestProfessor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCollaboRequestProfessor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCollaboRequestProfessor(PathMetadata metadata, PathInits inits) {
        this(CollaboRequestProfessor.class, metadata, inits);
    }

    public QCollaboRequestProfessor(Class<? extends CollaboRequestProfessor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.collaboRequest = inits.isInitialized("collaboRequest") ? new QCollaboRequest(forProperty("collaboRequest"), inits.get("collaboRequest")) : null;
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
    }

}


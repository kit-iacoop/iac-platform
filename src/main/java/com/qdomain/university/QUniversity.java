package com.qdomain.university;

import com.domain.university.University;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QOfficer;
import com.qdomain.account.QProfessor;
import com.qdomain.common.QAddress;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QUniversity is a Querydsl query type for University
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUniversity extends EntityPathBase<University> {

    private static final long serialVersionUID = 666030513L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUniversity university = new QUniversity("university");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QAddress address;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final ListPath<com.domain.account.Officer, QOfficer> officer = this.<com.domain.account.Officer, QOfficer>createList("officer", com.domain.account.Officer.class, QOfficer.class, PathInits.DIRECT2);

    public final ListPath<com.domain.account.Professor, QProfessor> professorList = this.<com.domain.account.Professor, QProfessor>createList("professorList", com.domain.account.Professor.class, QProfessor.class, PathInits.DIRECT2);

    public final NumberPath<Long> universityId = createNumber("universityId", Long.class);

    public final StringPath universityName = createString("universityName");

    public QUniversity(String variable) {
        this(University.class, forVariable(variable), INITS);
    }

    public QUniversity(Path<? extends University> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUniversity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUniversity(PathMetadata metadata, PathInits inits) {
        this(University.class, metadata, inits);
    }

    public QUniversity(Class<? extends University> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
    }

}


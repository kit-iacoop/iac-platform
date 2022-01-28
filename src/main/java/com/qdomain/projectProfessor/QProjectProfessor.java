package com.qdomain.projectProfessor;

import com.domain.projectProfessor.ProjectProfessor;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QProfessor;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.project.QProject;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProjectProfessor is a Querydsl query type for ProjectProfessor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectProfessor extends EntityPathBase<ProjectProfessor> {

    private static final long serialVersionUID = -1829831119L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectProfessor projectProfessor = new QProjectProfessor("projectProfessor");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProfessor professor;

    public final QProject project;

    public final NumberPath<Long> projectProfessorId = createNumber("projectProfessorId", Long.class);

    public QProjectProfessor(String variable) {
        this(ProjectProfessor.class, forVariable(variable), INITS);
    }

    public QProjectProfessor(Path<? extends ProjectProfessor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectProfessor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectProfessor(PathMetadata metadata, PathInits inits) {
        this(ProjectProfessor.class, metadata, inits);
    }

    public QProjectProfessor(Class<? extends ProjectProfessor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}


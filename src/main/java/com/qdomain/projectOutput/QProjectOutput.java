package com.qdomain.projectOutput;

import com.domain.projectOutput.ProjectOutput;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.project.QProject;
import com.qdomain.proofFile.QProofFile;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProjectOutput is a Querydsl query type for ProjectOutput
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectOutput extends EntityPathBase<ProjectOutput> {

    private static final long serialVersionUID = 1897059657L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectOutput projectOutput = new QProjectOutput("projectOutput");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final EnumPath<com.domain.common.CopyrightType> outputType = createEnum("outputType", com.domain.common.CopyrightType.class);

    public final QProject project;

    public final NumberPath<Long> projectOutputId = createNumber("projectOutputId", Long.class);

    public final ListPath<com.domain.proofFile.ProofFile, QProofFile> proofFileList = this.<com.domain.proofFile.ProofFile, QProofFile>createList("proofFileList", com.domain.proofFile.ProofFile.class, QProofFile.class, PathInits.DIRECT2);

    public final EnumPath<com.domain.common.State> status = createEnum("status", com.domain.common.State.class);

    public QProjectOutput(String variable) {
        this(ProjectOutput.class, forVariable(variable), INITS);
    }

    public QProjectOutput(Path<? extends ProjectOutput> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectOutput(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectOutput(PathMetadata metadata, PathInits inits) {
        this(ProjectOutput.class, metadata, inits);
    }

    public QProjectOutput(Class<? extends ProjectOutput> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}


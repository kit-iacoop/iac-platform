package com.qdomain.proofFile;

import com.domain.proofFile.ProofFile;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.projectOutput.QProjectOutput;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProofFile is a Querydsl query type for ProofFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProofFile extends EntityPathBase<ProofFile> {

    private static final long serialVersionUID = -2027379307L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProofFile proofFile = new QProofFile("proofFile");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileSize = createString("fileSize");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProjectOutput projectOutput;

    public final NumberPath<Long> proofFileId = createNumber("proofFileId", Long.class);

    public QProofFile(String variable) {
        this(ProofFile.class, forVariable(variable), INITS);
    }

    public QProofFile(Path<? extends ProofFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProofFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProofFile(PathMetadata metadata, PathInits inits) {
        this(ProofFile.class, metadata, inits);
    }

    public QProofFile(Class<? extends ProofFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.projectOutput = inits.isInitialized("projectOutput") ? new QProjectOutput(forProperty("projectOutput"), inits.get("projectOutput")) : null;
    }

}


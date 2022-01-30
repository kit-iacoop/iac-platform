package com.qdomain.salesHistoryProofFile;

import com.domain.salesHistoryProofFile.SalesHistoryProofFile;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.projectSalesHistory.QProjectSalesHistory;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSalesHistoryProofFile is a Querydsl query type for SalesHistoryProofFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSalesHistoryProofFile extends EntityPathBase<SalesHistoryProofFile> {

    private static final long serialVersionUID = -371022459L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSalesHistoryProofFile salesHistoryProofFile = new QSalesHistoryProofFile("salesHistoryProofFile");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileSize = createString("fileSize");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProjectSalesHistory projectSalesHistory;

    public final NumberPath<Long> salesHistoryProofFileId = createNumber("salesHistoryProofFileId", Long.class);

    public QSalesHistoryProofFile(String variable) {
        this(SalesHistoryProofFile.class, forVariable(variable), INITS);
    }

    public QSalesHistoryProofFile(Path<? extends SalesHistoryProofFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSalesHistoryProofFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSalesHistoryProofFile(PathMetadata metadata, PathInits inits) {
        this(SalesHistoryProofFile.class, metadata, inits);
    }

    public QSalesHistoryProofFile(Class<? extends SalesHistoryProofFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.projectSalesHistory = inits.isInitialized("projectSalesHistory") ? new QProjectSalesHistory(forProperty("projectSalesHistory"), inits.get("projectSalesHistory")) : null;
    }

}


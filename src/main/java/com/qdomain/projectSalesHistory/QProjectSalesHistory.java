package com.qdomain.projectSalesHistory;

import com.domain.projectSalesHistory.ProjectSalesHistory;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.project.QProject;
import com.qdomain.salesHistoryProofFile.QSalesHistoryProofFile;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProjectSalesHistory is a Querydsl query type for ProjectSalesHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectSalesHistory extends EntityPathBase<ProjectSalesHistory> {

    private static final long serialVersionUID = 1450961559L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectSalesHistory projectSalesHistory = new QProjectSalesHistory("projectSalesHistory");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProject project;

    public final NumberPath<Long> projectSalesHistoryId = createNumber("projectSalesHistoryId", Long.class);

    public final ListPath<com.domain.salesHistoryProofFile.SalesHistoryProofFile, QSalesHistoryProofFile> proofFileList = this.<com.domain.salesHistoryProofFile.SalesHistoryProofFile, QSalesHistoryProofFile>createList("proofFileList", com.domain.salesHistoryProofFile.SalesHistoryProofFile.class, QSalesHistoryProofFile.class, PathInits.DIRECT2);

    public final StringPath sales = createString("sales");

    public final EnumPath<com.domain.common.State> status = createEnum("status", com.domain.common.State.class);

    public final StringPath year = createString("year");

    public QProjectSalesHistory(String variable) {
        this(ProjectSalesHistory.class, forVariable(variable), INITS);
    }

    public QProjectSalesHistory(Path<? extends ProjectSalesHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectSalesHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectSalesHistory(PathMetadata metadata, PathInits inits) {
        this(ProjectSalesHistory.class, metadata, inits);
    }

    public QProjectSalesHistory(Class<? extends ProjectSalesHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}


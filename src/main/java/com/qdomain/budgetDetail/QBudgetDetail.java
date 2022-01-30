package com.qdomain.budgetDetail;

import com.domain.budgetDetail.BudgetDetail;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.project.QProject;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QBudgetDetail is a Querydsl query type for BudgetDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBudgetDetail extends EntityPathBase<BudgetDetail> {

    private static final long serialVersionUID = -1364922063L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBudgetDetail budgetDetail = new QBudgetDetail("budgetDetail");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> budgetDetailId = createNumber("budgetDetailId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath humanCost = createString("humanCost");

    public final StringPath indirectCost = createString("indirectCost");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QProject project;

    public final StringPath researchActivity = createString("researchActivity");

    public final StringPath total = createString("total");

    public QBudgetDetail(String variable) {
        this(BudgetDetail.class, forVariable(variable), INITS);
    }

    public QBudgetDetail(Path<? extends BudgetDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBudgetDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBudgetDetail(PathMetadata metadata, PathInits inits) {
        this(BudgetDetail.class, metadata, inits);
    }

    public QBudgetDetail(Class<? extends BudgetDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}


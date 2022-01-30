package com.qdomain.applicationRegistration;

import com.domain.applicationRegistration.ApplicationRegistration;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.copyright.QCopyright;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QApplicationRegistration is a Querydsl query type for ApplicationRegistration
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApplicationRegistration extends EntityPathBase<ApplicationRegistration> {

    private static final long serialVersionUID = 302363431L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicationRegistration applicationRegistration = new QApplicationRegistration("applicationRegistration");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> applicationRegistrationId = createNumber("applicationRegistrationId", Long.class);

    public final QCopyright copyright;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DatePath<java.time.LocalDate> issueDate = createDate("issueDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath number = createString("number");

    public final StringPath type = createString("type");

    public QApplicationRegistration(String variable) {
        this(ApplicationRegistration.class, forVariable(variable), INITS);
    }

    public QApplicationRegistration(Path<? extends ApplicationRegistration> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicationRegistration(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicationRegistration(PathMetadata metadata, PathInits inits) {
        this(ApplicationRegistration.class, metadata, inits);
    }

    public QApplicationRegistration(Class<? extends ApplicationRegistration> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.copyright = inits.isInitialized("copyright") ? new QCopyright(forProperty("copyright"), inits.get("copyright")) : null;
    }

}


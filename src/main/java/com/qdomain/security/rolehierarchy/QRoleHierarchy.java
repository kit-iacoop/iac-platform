package com.qdomain.security.rolehierarchy;

import com.domain.security.rolehierarchy.RoleHierarchy;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRoleHierarchy is a Querydsl query type for RoleHierarchy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleHierarchy extends EntityPathBase<RoleHierarchy> {

    private static final long serialVersionUID = -1659297441L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoleHierarchy roleHierarchy = new QRoleHierarchy("roleHierarchy");

    public final SetPath<RoleHierarchy, QRoleHierarchy> childrenSet = this.<RoleHierarchy, QRoleHierarchy>createSet("childrenSet", RoleHierarchy.class, QRoleHierarchy.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRoleHierarchy parent;

    public final StringPath roleName = createString("roleName");

    public QRoleHierarchy(String variable) {
        this(RoleHierarchy.class, forVariable(variable), INITS);
    }

    public QRoleHierarchy(Path<? extends RoleHierarchy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoleHierarchy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoleHierarchy(PathMetadata metadata, PathInits inits) {
        this(RoleHierarchy.class, metadata, inits);
    }

    public QRoleHierarchy(Class<? extends RoleHierarchy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QRoleHierarchy(forProperty("parent"), inits.get("parent")) : null;
    }

}


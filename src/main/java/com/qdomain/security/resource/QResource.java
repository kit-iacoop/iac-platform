package com.qdomain.security.resource;

import com.domain.security.resource.Resource;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.security.role.QRole;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = -190168803L;

    public static final QResource resource = new QResource("resource");

    public final StringPath httpMethod = createString("httpMethod");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> orderNum = createNumber("orderNum", Integer.class);

    public final StringPath resourceName = createString("resourceName");

    public final StringPath resourceType = createString("resourceType");

    public final SetPath<com.domain.security.role.Role, QRole> roleSet = this.<com.domain.security.role.Role, QRole>createSet("roleSet", com.domain.security.role.Role.class, QRole.class, PathInits.DIRECT2);

    public QResource(String variable) {
        super(Resource.class, forVariable(variable));
    }

    public QResource(Path<? extends Resource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResource(PathMetadata metadata) {
        super(Resource.class, metadata);
    }

}


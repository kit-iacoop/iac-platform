package com.qdomain.security.accessip;

import com.domain.security.accessip.AccessIp;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QAccessIp is a Querydsl query type for AccessIp
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccessIp extends EntityPathBase<AccessIp> {

    private static final long serialVersionUID = 561125853L;

    public static final QAccessIp accessIp = new QAccessIp("accessIp");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ipAddress = createString("ipAddress");

    public QAccessIp(String variable) {
        super(AccessIp.class, forVariable(variable));
    }

    public QAccessIp(Path<? extends AccessIp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccessIp(PathMetadata metadata) {
        super(AccessIp.class, metadata);
    }

}


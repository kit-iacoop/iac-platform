package com.qdomain.security.role;

import com.domain.security.role.Role;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QAccount;
import com.qdomain.security.resource.QResource;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -400539363L;

    public static final QRole role = new QRole("role");

    public final SetPath<com.domain.account.Account, QAccount> accounts = this.<com.domain.account.Account, QAccount>createSet("accounts", com.domain.account.Account.class, QAccount.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<com.domain.security.resource.Resource, QResource> resourceSet = this.<com.domain.security.resource.Resource, QResource>createSet("resourceSet", com.domain.security.resource.Resource.class, QResource.class, PathInits.DIRECT2);

    public final StringPath roleDesc = createString("roleDesc");

    public final StringPath roleName = createString("roleName");

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}


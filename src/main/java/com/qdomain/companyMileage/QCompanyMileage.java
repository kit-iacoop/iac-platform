package com.qdomain.companyMileage;

import com.domain.companyMileage.CompanyMileage;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QCompany;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.mileageRequest.QMileageRequest;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCompanyMileage is a Querydsl query type for CompanyMileage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompanyMileage extends EntityPathBase<CompanyMileage> {

    private static final long serialVersionUID = 226066641L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyMileage companyMileage = new QCompanyMileage("companyMileage");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCompany company;

    public final NumberPath<Long> companyMileageId = createNumber("companyMileageId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> mileage = createNumber("mileage", Long.class);

    public final QMileageRequest mileageRequest;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public QCompanyMileage(String variable) {
        this(CompanyMileage.class, forVariable(variable), INITS);
    }

    public QCompanyMileage(Path<? extends CompanyMileage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyMileage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyMileage(PathMetadata metadata, PathInits inits) {
        this(CompanyMileage.class, metadata, inits);
    }

    public QCompanyMileage(Class<? extends CompanyMileage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
        this.mileageRequest = inits.isInitialized("mileageRequest") ? new QMileageRequest(forProperty("mileageRequest"), inits.get("mileageRequest")) : null;
    }

}


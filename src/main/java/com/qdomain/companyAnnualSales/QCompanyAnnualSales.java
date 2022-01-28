package com.qdomain.companyAnnualSales;

import com.domain.companyAnnualSales.CompanyAnnualSales;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.account.QCompany;
import com.qdomain.common.QBaseTimeEntity;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCompanyAnnualSales is a Querydsl query type for CompanyAnnualSales
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompanyAnnualSales extends EntityPathBase<CompanyAnnualSales> {

    private static final long serialVersionUID = 247481457L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyAnnualSales companyAnnualSales = new QCompanyAnnualSales("companyAnnualSales");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QCompany company;

    public final NumberPath<Long> companyAnnualSalesId = createNumber("companyAnnualSalesId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> sales = createNumber("sales", Long.class);

    public final NumberPath<Long> year = createNumber("year", Long.class);

    public QCompanyAnnualSales(String variable) {
        this(CompanyAnnualSales.class, forVariable(variable), INITS);
    }

    public QCompanyAnnualSales(Path<? extends CompanyAnnualSales> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyAnnualSales(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyAnnualSales(PathMetadata metadata, PathInits inits) {
        this(CompanyAnnualSales.class, metadata, inits);
    }

    public QCompanyAnnualSales(Class<? extends CompanyAnnualSales> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
    }

}


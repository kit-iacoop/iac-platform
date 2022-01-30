package com.qdomain.account;

import com.domain.account.Company;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.annualFee.QAnnualFee;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QAddress;
import com.qdomain.companyAnnualSales.QCompanyAnnualSales;
import com.qdomain.companyMileage.QCompanyMileage;
import com.qdomain.copyright.QCopyright;
import com.qdomain.item.QItem;
import com.qdomain.meetingAttendant.QMeetingAttendant;
import com.qdomain.mileageRequest.QMileageRequest;
import com.qdomain.project.QProject;
import com.qdomain.security.role.QRole;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 2074510207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompany company = new QCompany("company");

    public final QAccount _super;

    //inherited
    public final NumberPath<Long> accountId;

    //inherited
    public final SetPath<com.domain.security.role.Role, QRole> accountRoles;

    // inherited
    public final QAddress address;

    public final ListPath<com.domain.annualFee.AnnualFee, QAnnualFee> annualFee = this.<com.domain.annualFee.AnnualFee, QAnnualFee>createList("annualFee", com.domain.annualFee.AnnualFee.class, QAnnualFee.class, PathInits.DIRECT2);

    public final ListPath<com.domain.companyAnnualSales.CompanyAnnualSales, QCompanyAnnualSales> annualSalesList = this.<com.domain.companyAnnualSales.CompanyAnnualSales, QCompanyAnnualSales>createList("annualSalesList", com.domain.companyAnnualSales.CompanyAnnualSales.class, QCompanyAnnualSales.class, PathInits.DIRECT2);

    //inherited
    public final DatePath<java.time.LocalDate> birthDate;

    public final NumberPath<Long> businessRegistrationNumber = createNumber("businessRegistrationNumber", Long.class);

    public final ListPath<com.domain.collaboRequest.CollaboRequest, QCollaboRequest> collaboRequest = this.<com.domain.collaboRequest.CollaboRequest, QCollaboRequest>createList("collaboRequest", com.domain.collaboRequest.CollaboRequest.class, QCollaboRequest.class, PathInits.DIRECT2);

    public final StringPath companyType = createString("companyType");

    //inherited
    public final ListPath<com.domain.copyright.Copyright, QCopyright> copyrightList;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    public final EnumPath<com.domain.common.State> currentizationStatus = createEnum("currentizationStatus", com.domain.common.State.class);

    //inherited
    public final StringPath email;

    public final NumberPath<Long> employeeNumber = createNumber("employeeNumber", Long.class);

    public final StringPath grade = createString("grade");

    public final ListPath<com.domain.item.Item, QItem> itemList = this.<com.domain.item.Item, QItem>createList("itemList", com.domain.item.Item.class, QItem.class, PathInits.DIRECT2);

    //inherited
    public final StringPath loginId;

    //inherited
    public final ListPath<com.domain.meetingAttendant.MeetingAttendant, QMeetingAttendant> meetingAttendantList;

    public final QProfessor mentorProfessor;

    public final NumberPath<Long> mileage = createNumber("mileage", Long.class);

    public final ListPath<com.domain.companyMileage.CompanyMileage, QCompanyMileage> mileageList = this.<com.domain.companyMileage.CompanyMileage, QCompanyMileage>createList("mileageList", com.domain.companyMileage.CompanyMileage.class, QCompanyMileage.class, PathInits.DIRECT2);

    public final ListPath<com.domain.mileageRequest.MileageRequest, QMileageRequest> mileageRequest = this.<com.domain.mileageRequest.MileageRequest, QMileageRequest>createList("mileageRequest", com.domain.mileageRequest.MileageRequest.class, QMileageRequest.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    //inherited
    public final StringPath name;

    public final StringPath owner = createString("owner");

    //inherited
    public final StringPath password;

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final ListPath<com.domain.project.Project, QProject> projectList = this.<com.domain.project.Project, QProject>createList("projectList", com.domain.project.Project.class, QProject.class, PathInits.DIRECT2);

    public final StringPath sector = createString("sector");

    //inherited
    public final EnumPath<com.domain.common.State> status;

    public final DatePath<java.time.LocalDate> subscriptionDate = createDate("subscriptionDate", java.time.LocalDate.class);

    //inherited
    public final StringPath telephone;

    public final StringPath temporaryAddress = createString("temporaryAddress");

    public QCompany(String variable) {
        this(Company.class, forVariable(variable), INITS);
    }

    public QCompany(Path<? extends Company> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompany(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompany(PathMetadata metadata, PathInits inits) {
        this(Company.class, metadata, inits);
    }

    public QCompany(Class<? extends Company> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAccount(type, metadata, inits);
        this.accountId = _super.accountId;
        this.accountRoles = _super.accountRoles;
        this.address = _super.address;
        this.birthDate = _super.birthDate;
        this.copyrightList = _super.copyrightList;
        this.createdDate = _super.createdDate;
        this.email = _super.email;
        this.loginId = _super.loginId;
        this.meetingAttendantList = _super.meetingAttendantList;
        this.mentorProfessor = inits.isInitialized("mentorProfessor") ? new QProfessor(forProperty("mentorProfessor"), inits.get("mentorProfessor")) : null;
        this.modifiedDate = _super.modifiedDate;
        this.name = _super.name;
        this.password = _super.password;
        this.status = _super.status;
        this.telephone = _super.telephone;
    }

}


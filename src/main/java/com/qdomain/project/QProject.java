package com.qdomain.project;

import com.domain.project.Project;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.qdomain.account.QCompany;
import com.qdomain.budgetDetail.QBudgetDetail;
import com.qdomain.collaboRequest.QCollaboRequest;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.meeting.QMeeting;
import com.qdomain.projectOutput.QProjectOutput;
import com.qdomain.projectProfessor.QProjectProfessor;
import com.qdomain.projectSalesHistory.QProjectSalesHistory;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -358439161L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProject project = new QProject("project");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QBudgetDetail budgetDetail;

    public final QCollaboRequest collaboRequest;

    public final QCompany company;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final ListPath<com.domain.meeting.Meeting, QMeeting> meetingList = this.<com.domain.meeting.Meeting, QMeeting>createList("meetingList", com.domain.meeting.Meeting.class, QMeeting.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final ListPath<com.domain.projectProfessor.ProjectProfessor, QProjectProfessor> professorList = this.<com.domain.projectProfessor.ProjectProfessor, QProjectProfessor>createList("professorList", com.domain.projectProfessor.ProjectProfessor.class, QProjectProfessor.class, PathInits.DIRECT2);

    public final NumberPath<Long> projectId = createNumber("projectId", Long.class);

    public final ListPath<com.domain.projectOutput.ProjectOutput, QProjectOutput> projectOutputList = this.<com.domain.projectOutput.ProjectOutput, QProjectOutput>createList("projectOutputList", com.domain.projectOutput.ProjectOutput.class, QProjectOutput.class, PathInits.DIRECT2);

    public final ListPath<com.domain.projectSalesHistory.ProjectSalesHistory, QProjectSalesHistory> salesHistoryList = this.<com.domain.projectSalesHistory.ProjectSalesHistory, QProjectSalesHistory>createList("salesHistoryList", com.domain.projectSalesHistory.ProjectSalesHistory.class, QProjectSalesHistory.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QProject(String variable) {
        this(Project.class, forVariable(variable), INITS);
    }

    public QProject(Path<? extends Project> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProject(PathMetadata metadata, PathInits inits) {
        this(Project.class, metadata, inits);
    }

    public QProject(Class<? extends Project> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.budgetDetail = inits.isInitialized("budgetDetail") ? new QBudgetDetail(forProperty("budgetDetail"), inits.get("budgetDetail")) : null;
        this.collaboRequest = inits.isInitialized("collaboRequest") ? new QCollaboRequest(forProperty("collaboRequest"), inits.get("collaboRequest")) : null;
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company"), inits.get("company")) : null;
    }

}


package com.qdomain.mileageFile;

import com.domain.mileageFile.MileageFile;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.qdomain.common.QBaseTimeEntity;
import com.qdomain.common.QFileDetails;
import com.qdomain.mileageRequest.QMileageRequest;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMileageFile is a Querydsl query type for MileageFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMileageFile extends EntityPathBase<MileageFile> {

    private static final long serialVersionUID = 405413793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMileageFile mileageFile = new QMileageFile("mileageFile");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QFileDetails address;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> mileageFileId = createNumber("mileageFileId", Long.class);

    public final QMileageRequest mileageRequest;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMileageFile(String variable) {
        this(MileageFile.class, forVariable(variable), INITS);
    }

    public QMileageFile(Path<? extends MileageFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMileageFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMileageFile(PathMetadata metadata, PathInits inits) {
        this(MileageFile.class, metadata, inits);
    }

    public QMileageFile(Class<? extends MileageFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QFileDetails(forProperty("address")) : null;
        this.mileageRequest = inits.isInitialized("mileageRequest") ? new QMileageRequest(forProperty("mileageRequest"), inits.get("mileageRequest")) : null;
    }

}


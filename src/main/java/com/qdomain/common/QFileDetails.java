package com.qdomain.common;

import com.domain.common.FileDetails;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BeanPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QFileDetails is a Querydsl query type for FileDetails
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFileDetails extends BeanPath<FileDetails> {

    private static final long serialVersionUID = -1984057152L;

    public static final QFileDetails fileDetails = new QFileDetails("fileDetails");

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileSize = createString("fileSize");

    public QFileDetails(String variable) {
        super(FileDetails.class, forVariable(variable));
    }

    public QFileDetails(Path<? extends FileDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileDetails(PathMetadata metadata) {
        super(FileDetails.class, metadata);
    }

}


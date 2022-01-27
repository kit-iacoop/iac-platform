package com.domain.collaboRequest;

import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.collaboRequestTechnique.QCollaboRequestTechnique;
import com.domain.common.RequestType;
import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.QFieldCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CollaboRequestRepositoryCustomImpl
        implements CollaboRequestRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QCollaboRequest collaboRequest = QCollaboRequest.collaboRequest;
    private final QCollaboRequestTechnique collaboRequestTechnique = QCollaboRequestTechnique.collaboRequestTechnique;
    private final QFieldCategory fieldCategory = QFieldCategory.fieldCategory;

    @Override
    public Page<CollaboRequest> search(RequestQueryCondition condition, Pageable pageable) {

        List<CollaboRequest> results = queryFactory
                .select(collaboRequest).from(collaboRequest)
                .where(
                        eqRequestType(condition.getType()),
                        eqTermType(condition.getTermType()),
                        eqIsCapstone(condition.getIsCapstone()),
                        containTitle(condition.getKey()),
                        eqCategories(condition.getFieldCategoryList())
                ).distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(results, pageable, results.size());
    }

    private BooleanExpression eqRequestType(RequestType type) {
        if (type == null) {
            return null;
        }
        return collaboRequest.requestType.eq(type);
    }

    private BooleanExpression eqTermType(String termType) {
        if (termType.isEmpty() | termType.equals("all")) {
            return null;
        }
        return collaboRequest.termType.eq(termType);
    }

    private BooleanExpression eqIsCapstone(String isCapstone) {
        if (isCapstone.equals("")) {
            return null;
        }
        return collaboRequest.isCapstone.eq(isCapstone);
    }

    private BooleanExpression eqCategories(List<FieldCategory> categories) {
        if (categories == null | categories.size() == 0) {
            return null;
        }

        return collaboRequestTechnique.fieldCategory.fieldCategoryId.in(categories.stream().map(FieldCategory::getFieldCategoryId).collect(Collectors.toList()));
    }

    private BooleanExpression containTitle(String title) {
        if (title.equals("")) {
            return null;
        }
        return collaboRequest.title.contains(title);
    }

}
package com.domain.collaboRequest;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CollaboRequestRepositoryCustomImpl
        implements CollaboRequestRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<CollaboRequest> search(RequestQueryCondition condition, Pageable pageable) {
        QCollaboRequest collaboRequest = QCollaboRequest.collaboRequest;

        List<CollaboRequest> results = queryFactory
                .selectFrom(collaboRequest)
                .where(collaboRequest.requestType.eq(condition.getType()),
                        collaboRequest.termType.eq(condition.getTermType()),
                        collaboRequest.isCapstone.eq(condition.getIsCapstone()),
                        collaboRequest.title.contains(condition.getKey()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(results, pageable, results.size());
    }
}

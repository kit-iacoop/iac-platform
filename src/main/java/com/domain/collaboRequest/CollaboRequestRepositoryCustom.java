package com.domain.collaboRequest;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CollaboRequestRepositoryCustom {
    Page<CollaboRequest> search(RequestQueryCondition condition, Pageable pageable);
}

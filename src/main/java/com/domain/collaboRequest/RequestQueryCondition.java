package com.domain.collaboRequest;

import com.domain.common.RequestType;
import com.domain.fieldCategory.FieldCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

public class RequestQueryCondition {
    private RequestType type;
    private String key;
    private String term;
    private String termType;
    private List<FieldCategory> fieldCategoryList;
    private String isCapstone;
    private String isFusion;
}

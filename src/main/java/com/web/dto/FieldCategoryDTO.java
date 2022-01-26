package com.web.dto;

import com.domain.fieldCategory.FieldCategory;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FieldCategoryDTO {
    String fieldCategoryId;
    String categoryName;
    String level;

    public FieldCategoryDTO(FieldCategory fieldCategory) {
        this.fieldCategoryId = String.valueOf(fieldCategory.getFieldCategoryId());
        this.categoryName = fieldCategory.getCategoryName();
        this.level = String.valueOf(fieldCategory.getLevel());
    }
}

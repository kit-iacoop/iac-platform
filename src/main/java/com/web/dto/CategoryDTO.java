package com.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer categoryId;
    private String collaborationName;
    private Integer level;
    private Integer parentCategoryId;

    public CategoryDTO(Integer categoryId, String collaborationName, Integer level) {
        this.categoryId = categoryId;
        this.collaborationName = collaborationName;
        this.level = level;
    }
}
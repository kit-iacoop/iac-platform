package com.web.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CollaborationCategoryDTO {
    private Long categoryId;
    private String collaborationName;
    private Integer level;
    private Long parentCategoryId;

}
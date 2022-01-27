package com.web.dto;

import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.fieldCategory.FieldCategory;
import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CollaboRequestTechniqueDTO {
    private String collaboRequestTechniqueId;
    private String collaboRequestId;
    private String fieldCategoryId;
    private String fieldCategoryName;

    // 예를들어 기술에 웹서비스, 컴퓨터 두 항목이 있을 때
    // 웹서비스기술 카테고리 트리가 (기술공학>컴퓨터>웹서비스) 구조,
    // fieldCategoryTree 내부 list 에는 list('웹서비스', '컴퓨터', '공학') 이런 형태로 저장되어있음.
    private List<String> fieldCategoryTree;
    private String fieldCategoryParentId;

    public CollaboRequestTechniqueDTO(CollaboRequestTechnique collaboRequestTechnique) {
        this.collaboRequestTechniqueId = String.valueOf(collaboRequestTechnique.getCollaboRequestTechniqueId());
        this.collaboRequestId = String.valueOf(collaboRequestTechnique.getCollaboRequest().getCollaboRequestId());
        this.fieldCategoryId = String.valueOf(collaboRequestTechnique.getFieldCategory().getFieldCategoryId());
        this.fieldCategoryName = collaboRequestTechnique.getFieldCategory().getCategoryName();

        FieldCategory cursor = collaboRequestTechnique.getFieldCategory();
        List<String> tree = new LinkedList<>();
        tree.add(cursor.getCategoryName());
        while (cursor.getParentCategory() != null) {
            cursor = cursor.getParentCategory();
            tree.add(cursor.getCategoryName());
        }
        fieldCategoryTree = tree;
        if (tree.size() > 1) {
            fieldCategoryParentId = String.valueOf(collaboRequestTechnique.getFieldCategory().getParentCategory().getFieldCategoryId());
        }
    }
}

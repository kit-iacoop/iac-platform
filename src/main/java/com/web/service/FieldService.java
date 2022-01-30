package com.web.service;


import com.domain.fieldCategory.FieldCategory;
import com.web.dto.FieldCategoryDTO;

import java.util.List;

public interface FieldService {

    List<FieldCategoryDTO> getAllCategory();

    List<FieldCategoryDTO> getChildren(Long parentId);

}

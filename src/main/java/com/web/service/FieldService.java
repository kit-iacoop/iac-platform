package com.web.service;


import com.web.dto.FieldCategoryDTO;

import java.util.List;

public interface FieldService {

    List<FieldCategoryDTO> getChildren(Long parentId);
}

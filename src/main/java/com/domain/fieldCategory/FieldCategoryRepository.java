package com.domain.fieldCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldCategoryRepository extends JpaRepository<FieldCategory, Long> {
    List<FieldCategory> findAllByParentCategory(FieldCategory parentCategory);
}

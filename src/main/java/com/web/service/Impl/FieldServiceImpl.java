package com.web.service.Impl;

import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.FieldCategoryRepository;
import com.web.dto.FieldCategoryDTO;
import com.web.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class FieldServiceImpl implements FieldService {

    private final FieldCategoryRepository fieldCategoryRepository;

    @Override
    public List<FieldCategoryDTO> getChildren(Long parentId) {
        Optional<FieldCategory> maybeParent = Optional.empty();
        if (parentId == -1L) {
            maybeParent = fieldCategoryRepository.findById(1L);
            if (maybeParent.isPresent()) {
                return List.of(new FieldCategoryDTO(maybeParent.get()));
            }
        }
        maybeParent = fieldCategoryRepository.findById(parentId);
        if (maybeParent.isPresent()) {
            List<FieldCategory> findAllField = fieldCategoryRepository.findAllByParentCategory(maybeParent.get());
            return findAllField.stream().map(FieldCategoryDTO::new).collect(Collectors.toList());
        }
        return null;
    }
}

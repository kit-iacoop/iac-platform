package com.web.service.Impl;

import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.FieldCategoryRepository;
import com.web.dto.FieldCategoryDTO;
import com.web.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {

    private final FieldCategoryRepository fieldCategoryRepository;

    @Override
    public List<FieldCategoryDTO> getAllCategory() {
        Deque<FieldCategory> deque = new ArrayDeque<>(fieldCategoryRepository.findAllByParentCategory(null));
        List<FieldCategory> ordered = new ArrayList<>();

        while (!deque.isEmpty()) {
            FieldCategory pop = deque.getLast();
            deque.removeLast();
            if (!ordered.contains(pop)) {
                ordered.add(pop);
                for (FieldCategory fc : fieldCategoryRepository.findAllByParentCategory(pop)) {
                    deque.addLast(fc);
                }
            }
        }

        return ordered.stream().map(FieldCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<FieldCategoryDTO> getChildren(Long parentId) {
        if (parentId == -1L) {
            return fieldCategoryRepository.findAllByParentCategory(null).stream().map(FieldCategoryDTO::new).collect(Collectors.toList());
        }
        Optional<FieldCategory> maybeParent = fieldCategoryRepository.findById(parentId);
        if (maybeParent.isPresent()) {
            List<FieldCategory> findAllField = fieldCategoryRepository.findAllByParentCategory(maybeParent.get());
            return findAllField.stream().map(FieldCategoryDTO::new).collect(Collectors.toList());
        }
        return null;
    }

}
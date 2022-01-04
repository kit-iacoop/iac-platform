package com.domain.FieldCategory;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "FIELD_CATEGORY")
public class FieldCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_CATEGORY_ID", nullable = false)
    private Long fieldCategoryId;

    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @Column(name = "PARENT_CATEGORY")
    private String parentCategory;

    @Column(name = "LEVEL", nullable = false)
    private Long level;


}

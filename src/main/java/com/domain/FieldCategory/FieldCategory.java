package com.domain.FieldCategory;

import com.domain.CollaboRequestTechnique.CollaboRequestTechnique;
import com.domain.FieldInterest.FieldInterest;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "PARENT_CATEGORY")
    private FieldCategory parentCategory;

    @Column(name = "LEVEL", nullable = false)
    private Long level;

    @OneToMany(mappedBy = "fieldCategory")
    private List<CollaboRequestTechnique> collaboRequestTechniqueList = new ArrayList<>();

    @OneToMany(mappedBy = "fieldCategoryId")
    private List<FieldInterest> fieldInterestList = new ArrayList<>();

    public void setFieldCategory(Long fieldCategoryId) {
        this.fieldCategoryId = fieldCategoryId;
    }
}

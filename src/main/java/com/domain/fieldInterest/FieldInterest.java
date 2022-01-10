package com.domain.fieldInterest;

import com.domain.fieldCategory.FieldCategory;
import com.domain.account.Professor;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "FIELD_INTEREST")
public class FieldInterest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_INTEREST_ID", nullable = false)
    private Long fieldInterestId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ACCOUNT_ID", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "FIELD_CATEGORY_ID", nullable = false)
    private FieldCategory fieldCategoryId;

    public void setProfessor(Professor professor) {
        if (this.professor != null) {
            this.professor.getInterestedFieldList().remove(this);
        }
        this.professor = professor;
        professor.getInterestedFieldList().add(this);
    }

    public void setFieldCategory(FieldCategory fieldCategoryId) {
        if (this.fieldCategoryId != null) {
            this.fieldCategoryId.getFieldInterestList().remove(this);
        }
        this.fieldCategoryId = fieldCategoryId;
        fieldCategoryId.getFieldInterestList().add(this);
    }
}

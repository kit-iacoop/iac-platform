package com.domain.FieldInterest;

import com.domain.Account.Account;
import com.domain.FieldCategory.FieldCategory;
import com.domain.Account.Professor.Professor;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public void setAccount(Professor accountId) {
        if (this.professor != null) {
            this.professor.getFieldInterestList().remove(this);
        }
        this.professor = accountId;
        accountId.getFieldInterestList().add(this);
    }

    public void setFieldCategory(FieldCategory fieldCategoryId) {
        if (this.fieldCategoryId != null) {
            this.fieldCategoryId.getFieldInterestList().remove(this);
        }
        this.fieldCategoryId = fieldCategoryId;
        fieldCategoryId.getFieldInterestList().add(this);
    }
}

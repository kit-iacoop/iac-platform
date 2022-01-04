package com.domain.FieldInterest;

import com.domain.Account.Account;
import com.domain.FieldCategory.FieldCategory;
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

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "FIELD_CATEGORY_ID", nullable = false)
    private FieldCategory fieldCategoryId;

    public void setAccount(Account accountId) {
        if (this.accountId != null) {
            this.accountId.getFieldInterestList().remove(this);
        }
        this.accountId = accountId;
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

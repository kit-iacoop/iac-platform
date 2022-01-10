package com.domain.item;

import com.domain.account.Company;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ITEM")
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", nullable = false)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;

    @Column(name = "ITEM_NAME", nullable = false)
    private String itemName;

    public void setCompany(Company companyId) {
        if (this.company != null) {
            this.company.getItemList().remove(this);
        }
        this.company = companyId;
        companyId.getItemList().add(this);
    }
}

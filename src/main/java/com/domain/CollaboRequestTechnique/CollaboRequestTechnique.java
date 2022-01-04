package com.domain.CollaboRequestTechnique;

import com.domain.CollaboRequest.CollaboRequest;
import com.domain.FieldCategory.FieldCategory;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABO_REQUEST_TECHNIQUE")
public class CollaboRequestTechnique extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_TECHNIQUE_ID", nullable = false)
    private Long collaboRequestTechniqueId;

    @ManyToOne
    @JoinColumn(name = "FIELD_CATEGORY_ID", nullable = false)
    private FieldCategory fieldCategoryId;

    @ManyToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequestId;

    public void setFieldCategory(FieldCategory fieldCategoryId) {
        if (this.fieldCategoryId != null) {
            this.fieldCategoryId.getCollaboRequestTechniqueList().remove(this);
        }
        this.fieldCategoryId = fieldCategoryId;
        fieldCategoryId.getCollaboRequestTechniqueList().add(this);
    }

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequestId != null) {
            this.collaboRequestId.getCollaboRequestTechniqueList().remove(this);
        }
        this.collaboRequestId = collaboRequestId;
        collaboRequestId.getCollaboRequestTechniqueList().add(this);
    }
}

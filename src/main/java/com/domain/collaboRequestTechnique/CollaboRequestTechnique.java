package com.domain.collaboRequestTechnique;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.fieldCategory.FieldCategory;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@SuperBuilder
@Table(name = "COLLABO_REQUEST_TECHNIQUE")
public class CollaboRequestTechnique extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_TECHNIQUE_ID", nullable = false)
    private Long collaboRequestTechniqueId;

    @ManyToOne
    @JoinColumn(name = "FIELD_CATEGORY_ID", nullable = false)
    private FieldCategory fieldCategory;

    @ManyToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequest;

    public void setFieldCategory(FieldCategory fieldCategoryId) {
        if (this.fieldCategory != null) {
            this.fieldCategory.getCollaboRequestTechniqueList().remove(this);
        }
        this.fieldCategory = fieldCategoryId;
        fieldCategoryId.getCollaboRequestTechniqueList().add(this);
    }

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequest != null) {
            this.collaboRequest.getCollaboRequestTechniqueList().remove(this);
        }
        this.collaboRequest = collaboRequestId;
        collaboRequestId.getCollaboRequestTechniqueList().add(this);
    }
}

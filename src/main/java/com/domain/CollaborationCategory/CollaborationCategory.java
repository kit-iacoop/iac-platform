package com.domain.CollaborationCategory;

import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABORATION_CATEGORY")
public class CollaborationCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABORATION_CATEGORY_ID", nullable = false)
    private Long collaborationCategoryId;

    // 자기참조 부분. 이렇게 하는게 맞나?
    @OneToOne
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private CollaborationCategory parentCategoryId;

    @Column(name = "COLLABORATION_NAME", nullable = false)
    private String collaborationName;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;

    public void setParentCategory(CollaborationCategory parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}

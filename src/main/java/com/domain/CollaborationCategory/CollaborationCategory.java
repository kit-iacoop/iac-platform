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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private CollaborationCategory parentCategory;

    @Column(name = "COLLABORATION_NAME", nullable = false)
    private String collaborationName;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;


}

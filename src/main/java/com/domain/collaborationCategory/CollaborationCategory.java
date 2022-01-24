package com.domain.collaborationCategory;

import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABORATION_CATEGORY")
public class CollaborationCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABORATION_CATEGORY_ID", nullable = false)
    private Long collaborationCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private CollaborationCategory parentCategory;

    @Column(name = "COLLABORATION_NAME", nullable = false)
    private String collaborationName;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;

    @OneToMany(mappedBy =  "parentCategory", fetch = FetchType.LAZY)
    @JoinColumn
    private List<CollaborationCategory> children = new ArrayList<>();


}

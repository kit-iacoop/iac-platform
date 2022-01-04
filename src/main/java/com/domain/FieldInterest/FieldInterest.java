package com.domain.FieldInterest;

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

    @Column(name = "FIELD_CATEGORY_ID", nullable = false)
    private Long fieldCategoryId;


}

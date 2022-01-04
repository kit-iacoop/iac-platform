package com.domain.CollaboRequestProfessor;

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
@Table(name = "COLLABO_REQUEST_PROFESSOR")
public class CollaboRequestProfessor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_PROFESSOR_ID", nullable = false)
    private Long collaboRequestProfessorId;

    @Column(name = "COLLABO_REQUEST_ID", nullable = false)
    private Long collaboRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ACCOUNT_ID", nullable = false)
    private Professor professor;


}

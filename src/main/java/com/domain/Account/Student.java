package com.domain.Account;

import com.domain.Account.Account;
import com.domain.CollaboRequestProfessor.CollaboRequestProfessor;
import com.domain.FieldInterest.FieldInterest;
import com.domain.ProjectProfessor.ProjectProfessor;
import com.domain.University.University;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter

@DiscriminatorValue("S")
@Table(name = "STUDENT")
@Entity
public class Student extends Account {

    @Column(name = "STUDENT_NUMBER", nullable = false)
    private Long studentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIVERSITY_ID", nullable = false)
    private University university;

    @Column(name = "DEPARTMENT", nullable = false)
    private String department;

}
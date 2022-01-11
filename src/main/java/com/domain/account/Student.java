package com.domain.account;

import com.domain.university.University;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@SuperBuilder

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

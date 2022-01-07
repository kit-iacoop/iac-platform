package com.domain.University;

import com.domain.Account.Officer;
import com.domain.Account.Professor;
import com.domain.common.Address;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "UNIVERSITY")
public class University extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIVERSITY_ID", nullable = false, unique = true)
    private Long universityId;

    @Column(name = "UNIVERSITY_NAME", nullable = false, unique = true)
    private String universityName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<Professor> professorList;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<Officer> officer;

}


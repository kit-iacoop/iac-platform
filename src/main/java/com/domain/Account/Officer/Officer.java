package com.domain.Account.Officer;

import com.domain.Account.Account;
import com.domain.CollaboRequest.CollaboRequest;
import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter

@DiscriminatorValue("O")
@Table(name = "OFFICER")
@Entity
public class Officer extends Account {

    @Column(name = "UNIVERSITY_ID", nullable = false)
    private Long universityId;

    @Column(name = "OFFICE_LOCATION", nullable = false)
    private String officeLocation;

    @OneToMany(mappedBy = "officerAccountId")
    private List<CollaboRequest> collaboRequest = new ArrayList<>();

}

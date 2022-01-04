package com.domain.CollaboRequest;

import com.domain.common.BaseTimeEntity;

import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABO_REQUEST")
public class CollaboRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_ID", nullable = false)
    private Long collaboRequestId;

    @Column(name = "OFFICER_ACCOUNT_ID", nullable = false)
    private Long officerAccountId;

    @Column(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Long companyAccountId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "BUDGET", nullable = false)
    private Long budget;

    @Column(name = "TERM", nullable = false)
    private String term;

    @Column(name = "EXPIRE_DATE", nullable = false)
    private java.time.LocalDate expireDate;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

    // TODO: enum 형태로 되어야할것같음
    @Column(name = "REQUEST_TYPE", nullable = false)
    private String requestType;

}

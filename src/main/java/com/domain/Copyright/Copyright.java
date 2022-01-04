package com.domain.Copyright;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COPYRIGHT")
public class Copyright extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COPYRIGHT_TYPE", nullable = false)
    private String copyrightType;

    @Column(name = "INF_URL", nullable = false)
    private String infUrl;


}

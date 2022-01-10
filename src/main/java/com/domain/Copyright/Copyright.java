package com.domain.Copyright;

import com.domain.Account.Account;
import com.domain.ApplicationRegistration.ApplicationRegistration;
import com.domain.ParticipantCopyright.ParticipantCopyright;
import com.domain.common.BaseTimeEntity;
import com.domain.common.CopyrightType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COPYRIGHT")
public class Copyright extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COPYRIGHT_ID", nullable = false)
    private Long copyrightId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account accountId;

    @Column(name = "DECLARATION_YEAR", nullable = false)
    private String declarationYear;

    @Column(name = "COOPERATION", nullable = false)
    private String cooperation;

    @Enumerated(EnumType.STRING)
    @Column(name = "COPYRIGHT_TYPE", nullable = false)
    private CopyrightType copyrightType;

    // enum 혹은 목록 테이블 만들어서 참조하게? 하는 방향도 생각해볼것
    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "REPRESENTOR", nullable = false)
    private String representor;

    @Column(name = "PROFESSOR_DEPARTMENT", nullable = false)
    private String professorDepartment;

    @Column(name = "PROFESSOR_NAME", nullable = false)
    private String professorName;

    @Column(name = "PROFESSOR_RATIO") // between 0 and 100
    private Integer professorRatio;

    @Column(name = "KEYWORD")
    private String keyword;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MAINTENANCE_STATE")
    private String maintenanceState;

    @OneToMany(mappedBy = "copyright")
    List<ApplicationRegistration> applicationRegistrationList = new ArrayList<>();

    @OneToMany(mappedBy = "copyright")
    List<ParticipantCopyright> participantCopyrightList = new ArrayList<>();

    public void setAccount(Account accountId) {
        if (this.accountId != null) {
            this.accountId.getCopyrightList().remove(this);
        }
        this.accountId = accountId;
        accountId.getCopyrightList().add(this);
    }
}

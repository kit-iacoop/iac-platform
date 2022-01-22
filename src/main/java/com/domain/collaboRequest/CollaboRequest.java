package com.domain.collaboRequest;

import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.meeting.Meeting;
import com.domain.project.Project;
import com.domain.common.BaseTimeEntity;
import com.domain.common.RequestType;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@SuperBuilder
@Table(name = "COLLABO_REQUEST")
public class CollaboRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_ID", nullable = false)
    private Long collaboRequestId;

    @ManyToOne
    @JoinColumn(name = "OFFICER_ACCOUNT_ID", nullable = false)
    private Officer officer;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Company company;

    @Column(name = "TITLE", nullable = false)
    private String title;

    // 예산관련 필드. BudgetDetail 클래스에서 String으로 관리하므로 통일함
    // 생각해보니 BudgetDetail 필드에서 해당 내용 관리중이므로 정규화를 위해 제거
    @Column(name = "BUDGET", nullable = false)
    private String budget;

    @Column(name = "TERM", nullable = false)
    private String term;

    @Column(name = "EXPIRE_DATE", nullable = false)
    private LocalDate expireDate;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

    @Enumerated(EnumType.STRING)
    @Column(name = "REQUEST_TYPE", nullable = false)
    private RequestType requestType;

    @OneToMany(mappedBy = "collaboRequest")
    private List<CollaboRequestProfessor> collaboRequestProfessorList = new ArrayList<>();

    @OneToMany(mappedBy = "collaboRequest")
    private List<CollaboRequestTechnique> collaboRequestTechniqueList = new ArrayList<>();

    @OneToMany(mappedBy = "collaboRequest")
    private List<Meeting> meetingList = new ArrayList<>();

    @OneToOne
    private Project projectId;

    public void setOfficer(Officer officerAccountId) {
        if (this.officer != null) {
            this.officer.getCollaboRequest().remove(this);
        }
        this.officer = officerAccountId;
        officerAccountId.getCollaboRequest().add(this);
    }

    public void setCompany(Company companyAccountId) {
        if (this.company != null) {
            this.company.getCollaboRequest().remove(this);
        }
        this.company = companyAccountId;
        companyAccountId.getCollaboRequest().add(this);
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }
}

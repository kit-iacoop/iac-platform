package com.domain.CollaboRequest;

import com.domain.Account.Company.Company;
import com.domain.Account.Officer.Officer;
import com.domain.CollaboRequestProfessor.CollaboRequestProfessor;
import com.domain.CollaboRequestTechnique.CollaboRequestTechnique;
import com.domain.Meeting.Meeting;
import com.domain.Project.Project;
import com.domain.common.BaseTimeEntity;
import com.domain.common.RequestType;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COLLABO_REQUEST")
public class CollaboRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLABO_REQUEST_ID", nullable = false)
    private Long collaboRequestId;

    @ManyToOne
    @JoinColumn(name = "OFFICER_ACCOUNT_ID", nullable = false)
    private Officer officerAccountId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Company companyAccountId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    // 예산관련 필드. BudgetDetail 클래스에서 String으로 관리하므로 통일함
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

    @OneToMany(mappedBy = "collaboRequestId")
    private List<CollaboRequestProfessor> collaboRequestProfessorList = new ArrayList<>();

    @OneToMany(mappedBy = "collaboRequestId")
    private List<CollaboRequestTechnique> collaboRequestTechniqueList = new ArrayList<>();

    @OneToMany(mappedBy = "collaboRequestId")
    private List<Meeting> meetingList = new ArrayList<>();

    @OneToOne
    private Project projectId;

    public void setOfficer(Officer officerAccountId) {
        if (this.officerAccountId != null) {
            this.officerAccountId.getCollaboRequest().remove(this);
        }
        this.officerAccountId = officerAccountId;
        officerAccountId.getCollaboRequest().add(this);
    }

    public void setCompany(Company companyAccountId) {
        if (this.companyAccountId != null) {
            this.companyAccountId.getCollaboRequest().remove(this);
        }
        this.companyAccountId = companyAccountId;
        companyAccountId.getCollaboRequest().add(this);
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }
}

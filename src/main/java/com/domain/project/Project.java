package com.domain.project;

import com.domain.account.Company;
import com.domain.budgetDetail.BudgetDetail;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.meeting.Meeting;
import com.domain.projectOutput.ProjectOutput;
import com.domain.projectProfessor.ProjectProfessor;
import com.domain.projectSalesHistory.ProjectSalesHistory;
import com.domain.common.BaseTimeEntity;
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
@Table(name = "PROJECT")
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    // 여기서 CollaboRequest의 FK를 소유하는게 자연스러운듯
    @OneToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequest;

    // BudgetDetail에서 프로젝트의 FK를 소유하는게 자연스러운듯
    @OneToOne(mappedBy = "project")
    private BudgetDetail budgetDetail;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Company company;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "project")
    List<Meeting> meetingList = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    List<ProjectOutput> projectOutputList = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    List<ProjectProfessor> professorList = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    List<ProjectSalesHistory> salesHistoryList = new ArrayList<>();

    public void setBudgetDetail(BudgetDetail budgetDetailId) {
        this.budgetDetail = budgetDetailId;
    }

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequest != null) {
            this.collaboRequest.setProjectId(null);
        }
        this.collaboRequest = collaboRequestId;
    }

    public void setCompany(Company companyAccountId) {
        if (this.company != null) {
            this.company.getProjectList().remove(this);
        }
        this.company = companyAccountId;
        companyAccountId.getProjectList().add(this);
    }
}

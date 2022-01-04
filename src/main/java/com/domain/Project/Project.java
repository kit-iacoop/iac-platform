package com.domain.Project;

import com.domain.Account.Company.Company;
import com.domain.BudgetDetail.BudgetDetail;
import com.domain.CollaboRequest.CollaboRequest;
import com.domain.Meeting.Meeting;
import com.domain.ProjectOutput.ProjectOutput;
import com.domain.ProjectProfessor.ProjectProfessor;
import com.domain.ProjectSalesHistory.ProjectSalesHistory;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT")
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    // 여기서 CollaboRequest의 FK를 소유하는게 자연스러운듯
    @OneToOne
    @JoinColumn(name = "COLLABO_REQUEST_ID", nullable = false)
    private CollaboRequest collaboRequestId;

    // BudgetDetail에서 프로젝트의 FK를 소유하는게 자연스러운듯
    @OneToOne(mappedBy = "projectId")
    private BudgetDetail budgetDetailId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
    private Company companyAccountId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "projectId")
    List<Meeting> meetingList = new ArrayList<>();

    @OneToMany(mappedBy = "projectId")
    List<ProjectOutput> projectOutputList = new ArrayList<>();

    @OneToMany(mappedBy = "projectId")
    List<ProjectProfessor> professorList = new ArrayList<>();

    @OneToMany(mappedBy = "projectId")
    List<ProjectSalesHistory> salesHistoryList = new ArrayList<>();

    public void setBudgetDetailId(BudgetDetail budgetDetailId) {
        this.budgetDetailId = budgetDetailId;
    }

    public void setCollaboRequest(CollaboRequest collaboRequestId) {
        if (this.collaboRequestId != null) {
            this.collaboRequestId.setProjectId(null);
        }
        this.collaboRequestId = collaboRequestId;
    }

    public void setCompany(Company companyAccountId) {
        if (this.companyAccountId != null) {
            this.companyAccountId.getProjectList().remove(this);
        }
        this.companyAccountId = companyAccountId;
        companyAccountId.getProjectList().add(this);
    }
}

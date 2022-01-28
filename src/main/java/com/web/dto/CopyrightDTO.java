package com.web.dto;

import com.domain.copyright.Copyright;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CopyrightDTO {
    private String copyrightId;
    private String accountId;
    //    private String accountType;
    private String copyrightName;
    private String declarationYear;
    private String cooperation;
    private String copyrightType;
    private String copyrightState;
    private String representor;
    private String professorName;
    private String professorDept;
    private String keyword;
    private String description;
    private String maintenanceState;
    private String applicationDate;
    private String applicationNumber;
    private String registrationDate;
    private String registrationNumber;
    private String createdDate;

    public CopyrightDTO(Copyright copyright) {
        this.copyrightId = String.valueOf(copyright.getCopyrightId());
        this.accountId = String.valueOf(copyright.getAccountId().getAccountId());
//        this.accountType
        this.copyrightName = copyright.getTitle();
        this.declarationYear = copyright.getDeclarationYear();
        this.cooperation = copyright.getCooperation();
        this.copyrightType = String.valueOf(copyright.getCopyrightType());
        this.copyrightState = copyright.getState();
        this.representor = copyright.getRepresentor();
        this.professorName = copyright.getProfessorName();
        this.professorDept = copyright.getProfessorDepartment();
        this.keyword = copyright.getKeyword();
        this.description = copyright.getDescription();
        this.maintenanceState = copyright.getMaintenanceState();
        this.createdDate = String.valueOf(copyright.getCreatedDate());
        this.applicationDate = "";
        this.applicationNumber = "";
        this.registrationDate = "";
        this.registrationNumber = "";

        if (copyright.getApplicationRegistrationList().size() != 0) {
            this.applicationDate = copyright.getApplicationRegistrationList().get(0).getIssueDate().toString();
            this.applicationNumber = copyright.getApplicationRegistrationList().get(0).getNumber();
            if (copyright.getApplicationRegistrationList().size() > 1) {
                this.registrationDate = copyright.getApplicationRegistrationList().get(1).getIssueDate().toString();
                this.registrationNumber = copyright.getApplicationRegistrationList().get(1).getNumber();
            }
        }

    }

}

package com.web.dto;

import com.domain.account.Account;
import com.domain.copyright.Copyright;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CopyrightDTO {
    private String copyrightId;
    private String accountName;
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

    public CopyrightDTO(Copyright copyright) {
        this.copyrightId = String.valueOf(copyright.getCopyrightId());
        this.accountName = copyright.getAccountId().getName();
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
    }

}

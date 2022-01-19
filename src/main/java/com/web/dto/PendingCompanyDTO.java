package com.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PendingCompanyDTO {

    private Long accountId;
    private String name;
    private String companyType;
    private String sector;

}

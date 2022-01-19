
package com.web.dto;

import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
import com.domain.security.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {


    private String id;
    @NotBlank
    private String roleName;
    private String roleDesc;


    public Role toEntity(){
        return Role.builder()
                .roleName(roleName)
                .roleDesc(roleDesc)
                .build()
                ;
    }


}



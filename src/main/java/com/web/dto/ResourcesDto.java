package com.web.dto;

import com.domain.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourcesDto{


    private String id;

    @NotBlank
    private String resourceName;

    private String httpMethod;

    @NotBlank
    private int orderNum;

    private String resourceType;

    @NotBlank
    private Set<Role> roleSet;

}

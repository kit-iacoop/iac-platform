package com.web.dto;

import com.domain.security.resource.Resource;
import com.domain.security.role.Role;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO {


    private String id;

    @NotBlank
    private String resourceName;

    private String httpMethod;

    @NotBlank
    private int orderNum;

    private String resourceType;

    private String roleName;

    @NotBlank
    private Set<Role> roleSet;

    public Resource toEntity(){
        return Resource.builder()
                .resourceName(resourceName)
                .httpMethod(httpMethod)
                .orderNum(orderNum)
                .resourceType(resourceType)
                .resourceName(resourceName)
                .roleSet(roleSet)
                .build();

    }
}


package com.domain.security.role;

import com.domain.account.Account;
import com.domain.security.resource.Resource;
import com.web.dto.RoleDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;



@Getter

@ToString(exclude = {"users", "resourcesSet"})
@Builder

@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

    @Builder.Default
    @OrderBy("order_num desc")
    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.LAZY)
    private Set<Resource> resourceSet = new LinkedHashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "accountRoles")
    private Set<Account> accounts = new HashSet<>();

    public RoleDto toDto() {
        return RoleDto.builder()
                .id(id.toString())
                .roleName(roleName)
                .roleDesc(roleDesc)
            .build();
    }
}



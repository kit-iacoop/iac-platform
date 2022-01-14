
package com.domain.security;

import com.domain.account.Account;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;



@Getter
@Setter
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

    @OrderBy("ordernum desc")
    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.LAZY)
    private Set<Resources> resourcesSet = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userRoles")
    private Set<Account> accounts = new HashSet<>();

}



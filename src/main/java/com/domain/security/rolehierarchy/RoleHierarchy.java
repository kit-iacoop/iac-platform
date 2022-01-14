package com.domain.security.rolehierarchy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name="ROLE_HIERARCHY")
public class RoleHierarchy implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_name", referencedColumnName = "role_name")
    private RoleHierarchy parent;

    @OneToMany(mappedBy = "parent", cascade={CascadeType.ALL})
    private Set<RoleHierarchy> childrenSet = new HashSet<RoleHierarchy>();
}
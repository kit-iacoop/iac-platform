package com.domain.security.resource;

import com.domain.security.role.Role;
import com.web.dto.ResourceDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter

@Builder

@ToString(exclude = {"roleSet"})
@EqualsAndHashCode(of = "id")


@NoArgsConstructor
@AllArgsConstructor

@EntityListeners(value = { AuditingEntityListener.class })

@Entity
@Table(name = "RESOURCE")
public class Resource implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "resource_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @Column(name = "http_method", nullable = false)
    private String httpMethod;

    @Column(name = "order_num", nullable = false)
    private int orderNum;

    @Column(name = "resource_type", nullable = false)
    private String resourceType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resources", joinColumns = { @JoinColumn(name = "resource_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roleSet = new HashSet<>();

    public ResourceDto toDto() {
        return ResourceDto.builder()
                .id(id.toString())
                .resourceName(resourceName)
                .httpMethod(httpMethod)
                .orderNum(orderNum)
                .resourceType(resourceType)
                .roleSet(roleSet)
                .build();

    }
}

package com.domain.security.accessip;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Builder

@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "ACCESS_IP")
public class AccessIp implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "IP_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "IP_ADDRESS", nullable = false, unique = true)
    private String ipAddress;

}
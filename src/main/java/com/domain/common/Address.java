package com.domain.common;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Getter

@NoArgsConstructor
@AllArgsConstructor

@ToString

@Embeddable
public class Address {
    @Column(name = "CITY", nullable = true)
    private String city;

    @Column(name = "STREET", nullable = true)
    private String street;

    @Column(name = "ZIPCODE", nullable = true)
    private Long zipCode;

}

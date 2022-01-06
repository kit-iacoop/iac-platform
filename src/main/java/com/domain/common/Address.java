package com.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "CITY", nullable = true)
    private String city;

    @Column(name = "STREET", nullable = true)
    private String street;

    @Column(name = "ZIPCODE", nullable = true)
    private Long zipCode;


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

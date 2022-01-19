package com.domain.common;

// PATENT : 특허 , PAPER : 논문
// 추후 필요시 더 추가
public enum CopyrightType {
    PATENT("특허"), PAPER("논문");

    private final String name;

    private CopyrightType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

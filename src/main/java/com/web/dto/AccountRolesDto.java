package com.web.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AccountRolesDto {
    private String id;
    private String loginId;
    private String email;
    private List<String> roles;
}

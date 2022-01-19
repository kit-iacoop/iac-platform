package com.web.dto.account;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AccountRolesDTO {
    private String id;
    private String loginId;
    private String email;
    private List<String> roles;
}

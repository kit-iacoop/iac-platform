package com.web.dto.account;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class AccountSearchDTO {

    private String accountId;
    private String dtype;
    private String name;
    private String department;
}

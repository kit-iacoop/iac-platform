package com.web.service;

import com.domain.account.Account;
import com.web.dto.AccountRolesDto;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public void createAccount(Account account);

    public void deleteAccountById(Long id);

    public Account getAccountById(Long id);
    public AccountRolesDto getAccountRolesDtoById(Long id);

    public void updateAccountRoles(AccountRolesDto accountRolesDto);

    public List<Account> getAllAccounts();
}


package com.web.service;

import com.domain.account.Account;
import com.web.dto.account.*;
import com.web.dto.PendingCompanyDTO;

import java.util.List;

public interface AccountService {
    public void createAccount(Account account);

    public void deleteAccountById(Long id);

    public Account getAccountById(Long id);

    public AccountRolesDTO getAccountRolesDtoById(Long id);

    public void updateAccountRoles(AccountRolesDTO accountRolesDto);

    public List<Account> getAllAccounts();

    public List<PendingCompanyDTO> getAllPendingCompanies();

    public List<AccountSearchDTO> findCompanyContainName(String name);

    public List<AccountSearchDTO> findProfessorContainName(String name);

    public List<AccountSearchDTO> findStudentContainName(String name);
}


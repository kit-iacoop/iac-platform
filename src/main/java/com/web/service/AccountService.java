package com.web.service;

import com.domain.account.Account;
import com.web.dto.account.AccountRolesDTO;
import com.web.dto.PendingCompanyDTO;
import com.web.dto.account.CompanyInformationDTO;
import com.web.dto.account.ProfessorInformationDTO;
import com.web.dto.account.StudentInformationDTO;

import java.util.List;

public interface AccountService {
    public void createAccount(Account account);

    public void deleteAccountById(Long id);

    public Account getAccountById(Long id);

    public AccountRolesDTO getAccountRolesDtoById(Long id);

    public void updateAccountRoles(AccountRolesDTO accountRolesDto);

    public List<Account> getAllAccounts();

    public List<PendingCompanyDTO> getAllPendingCompanies();

    public List<CompanyInformationDTO> findCompanyContainName(String name);

    public List<ProfessorInformationDTO> findProfessorContainName(String name);

    public List<StudentInformationDTO> findStudentContainName(String name);
}


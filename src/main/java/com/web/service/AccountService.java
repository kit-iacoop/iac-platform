package com.web.service;

import com.domain.account.Account;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.AccountRolesDTO;
import com.web.dto.PendingCompanyDTO;
import com.web.dto.account.CompanyInformationDTO;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface AccountService {
    public void createAccount(Account account);

    public void deleteAccountById(Long id);

    public Account getAccountById(Long id);
    public AccountRolesDTO getAccountRolesDtoById(Long id);

    public void updateAccountRoles(AccountRolesDTO accountRolesDto);

    public List<Account> getAllAccounts();

    public List<PendingCompanyDTO>getAllPendingCompanies();

    public ModelAndView updateAccountInformation(AccountInformationDTO accountDto, ModelAndView mav);
}


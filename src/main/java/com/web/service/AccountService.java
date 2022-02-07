package com.web.service;

import com.domain.account.Account;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.AccountRolesDTO;
import com.web.dto.account.*;
import com.web.dto.PendingCompanyDTO;
import com.web.dto.account.CompanyInformationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AccountService {
    public void createAccount(Account account);

    public void deleteAccountById(Long id);

    public Account getAccountById(Long id);

    public AccountRolesDTO getAccountRolesDtoById(Long id);

    public void updateAccountRoles(AccountRolesDTO accountRolesDto);

    public List<Account> getAllAccounts();

    public List<PendingCompanyDTO>getAllPendingCompanies();

    public ModelAndView updateAccountInformation(HttpServletRequest req, AccountInformationDTO accountDto, ModelAndView mav);

    public List<AccountSearchDTO> findCompanyContainName(String name);

    public List<AccountSearchDTO> findProfessorContainName(String name);

    public List<AccountSearchDTO> findStudentContainName(String name);

    public Account registrationAccept(Long accountId);
    public Account registrationReject(Long accountId);

    Account getPendingAccountById(Long accountId);

    Page<CompanyInformationDTO> findCompany(Pageable pageable);
    Page<CompanyInformationDTO> findCompanyByKey(Pageable pageable, String name);
    CompanyInformationDTO getCompanyById(String id);
}


package com.web.service.Impl;

import com.domain.account.*;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.web.dto.account.*;
import com.web.dto.PendingCompanyDTO;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@AllArgsConstructor

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ProfessorRepository professorRepository;
    private final CompanyRepository companyRepository;
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void createAccount(Account account) {
        accountRepository.encryptedSave(account);
    }

    @Transactional
    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Account getAccountById(Long id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()) {
            return null;
        }

        return optionalAccount.get();
    }

    @Transactional
    @Override
    public AccountRolesDTO getAccountRolesDtoById(Long id) {

        Account account = getAccountById(id);

        if (account == null) {
            return null;
        }

        return account.toAccountRolesDto();
    }

    @Transactional
    @Override
    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    @Transactional
    @Override
    public List<PendingCompanyDTO> getAllPendingCompanies() {

        return accountRepository.getAllPendingCompanies();
    }

    @Override
    public List<AccountSearchDTO> findCompanyContainName(String name) {
        List<AccountSearchDTO> list = new ArrayList<>();
        List<Company> byNameContains = companyRepository.findByNameContains(name);
        for (Company company : byNameContains) {
            list.add(AccountSearchDTO.builder()
                    .accountId(String.valueOf(company.getAccountId()))
                    .dtype("C")
                    .name(company.getName())
                    .department(company.getName())
                    .build());
        }
        return list;
    }

    @Override
    public List<AccountSearchDTO> findProfessorContainName(String name) {
        List<AccountSearchDTO> list = new ArrayList<>();
        List<Professor> byNameContains = professorRepository.findByNameContains(name);
        for (Professor professor : byNameContains) {
            list.add(AccountSearchDTO.builder()
                    .accountId(String.valueOf(professor.getAccountId()))
                    .dtype("P")
                    .name(professor.getName())
                    .department(professor.getDepartment())
                    .build());
        }
        return list;
    }

    @Override
    public List<AccountSearchDTO> findStudentContainName(String name) {
        List<AccountSearchDTO> list = new ArrayList<>();
        List<Student> byNameContains = studentRepository.findByNameContains(name);
        for (Student student : byNameContains) {
            list.add(AccountSearchDTO.builder()
                    .accountId(String.valueOf(student.getAccountId()))
                    .dtype("S")
                    .name(student.getName())
                    .department(student.getDepartment())
                    .build());
        }
        return list;
    }

    @Transactional
    @Override
    public void updateAccountRoles(AccountRolesDTO accountRolesDto) {
        Account account = getAccountById(Long.parseLong(accountRolesDto.getId()));

        if (accountRolesDto.getRoles() != null) {
            Set<Role> roles = new HashSet<>();

            accountRolesDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });

            account.updateRoles(roles);
        }

    }
}

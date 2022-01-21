package com.web.service.Impl;

import com.domain.account.*;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.web.dto.account.AccountRolesDTO;
import com.web.dto.PendingCompanyDTO;
import com.web.dto.account.CompanyInformationDTO;
import com.web.dto.account.ProfessorInformationDTO;
import com.web.dto.account.StudentInformationDTO;
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
    public List<CompanyInformationDTO> findCompanyContainName(String name) {
        List<CompanyInformationDTO> list = new ArrayList<>();
        List<Company> byNameContains = companyRepository.findByNameContains(name);
        for (Company company : byNameContains) {
            list.add(CompanyInformationDTO.builder()
                    .accountId(company.getAccountId())
                    .loginId(company.getLoginId())
                    .password(company.getPassword())
                    .name(company.getName())
                    .birthDate(String.valueOf(company.getBirthDate()))
                    .city(company.getAddress().getCity())
                    .street(company.getAddress().getStreet())
                    .zipCode(company.getAddress().getZipCode())
                    .email(company.getEmail())
                    .telephone(company.getTelephone())
                    .status(company.getStatus())
                    .businessRegistrationNumber(company.getBusinessRegistrationNumber())
                    .employeeNumber(company.getEmployeeNumber())
                    .companyType(company.getCompanyType())
                    .sector(company.getSector())
                    .owner(company.getOwner())
                    .subscriptionDate(String.valueOf(company.getSubscriptionDate()))
                    .build());
        }
        return list;
    }

    @Override
    public List<ProfessorInformationDTO> findProfessorContainName(String name) {
        List<ProfessorInformationDTO> list = new ArrayList<>();
        List<Professor> byNameContains = professorRepository.findByNameContains(name);
        for (Professor professor : byNameContains) {
            list.add(ProfessorInformationDTO.builder()
                    .accountId(professor.getAccountId())
                    .loginId(professor.getLoginId())
                    .password(professor.getPassword())
                    .name(professor.getName())
                    .birthDate(String.valueOf(professor.getBirthDate()))
                    .city(professor.getAddress().getCity())
                    .street(professor.getAddress().getStreet())
                    .zipCode(professor.getAddress().getZipCode())
                    .email(professor.getEmail())
                    .telephone(professor.getTelephone())
                    .status(professor.getStatus())
                    .university(professor.getUniversity().getUniversityName())
                    .officeLocation(professor.getOfficeLocation())
                    .department(professor.getDepartment())
                    .build());
        }
        return list;
    }

    @Override
    public List<StudentInformationDTO> findStudentContainName(String name) {
        List<StudentInformationDTO> list = new ArrayList<>();
        List<Student> byNameContains = studentRepository.findByNameContains(name);
        for (Student student : byNameContains) {
            list.add(StudentInformationDTO.builder()
                    .accountId(student.getAccountId())
                    .loginId(student.getLoginId())
                    .password(student.getPassword())
                    .name(student.getName())
                    .birthDate(String.valueOf(student.getBirthDate()))
                    .city(student.getAddress().getCity())
                    .street(student.getAddress().getStreet())
                    .zipCode(student.getAddress().getZipCode())
                    .email(student.getEmail())
                    .telephone(student.getTelephone())
                    .status(student.getStatus())
                    .university(student.getUniversity().getUniversityName())
                    .department(student.getDepartment())
                    .studentNumber(student.getStudentNumber())
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

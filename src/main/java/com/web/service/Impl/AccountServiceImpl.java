package com.web.service.Impl;

import com.common.Common;
import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.common.State;
import com.domain.account.*;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.security.service.AccountContext;
import com.web.dto.account.AccountInformationDTO;
import com.web.dto.account.AccountRolesDTO;
import com.web.dto.account.*;
import com.web.dto.PendingCompanyDTO;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.*;

@AllArgsConstructor
@Slf4j

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserDetailsService userDetailsService;
    private final ProfessorRepository professorRepository;
    private final CompanyRepository companyRepository;
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final Common common;
    
    @Transactional
    @Override
    public ModelAndView updateAccountInformation(HttpServletRequest req, AccountInformationDTO accInfDto, ModelAndView mav) {

        // 입력된 id, pw
        String inputID = accInfDto.getLoginId();
        String inputPW = accInfDto.getPassword();
        
        // 원본 id, pw
        String originalID = common.getAccountContext().getAccount().getLoginId();
        String originalPW = common.getAccountContext().getAccount().getPassword();
        
        
        // id/pw 검증
        // 실패 시 기존 창 유지
        if(!inputID.equals(originalID) || !passwordEncoder.matches(inputPW, originalPW)){
            mav.addObject("account", accInfDto);
            mav.setViewName(common.getReqUrlPrefix(req) + "/mypage/update-info");
            return mav;
        }


        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(inputID);
        Account account = accountContext.getAccount();


        accInfDto.setPassword(passwordEncoder.encode(accInfDto.getPassword()));
        account.updateInformation(accInfDto);


        //업데이트 된 Account 객체 반영
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        accountContext, null, accountContext.getAuthorities()
                );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //조회페이지로 리다이렉트
        mav.setViewName("redirect:/"+ common.getReqUrlPrefix(req) + "/mypage");

        return mav;
    }

    @Transactional
    @Override
    public Account registrationAccept(Long accountId) {
        log.warn("registrationAccept()");
        Account account = accountRepository.findByAccountId(accountId);

        if(account == null){
            //TODO : 해당 계정 존재하지 않는 예외 발생
            return null;
        }

        account.acceptRegistration();

        return account;
    }

    @Transactional
    @Override
    public Account registrationReject(Long accountId) {

        Account account = accountRepository.findByAccountId(accountId);

        if(account == null){
//            throw new Exception();
            return null;
        }
        account.rejectRegistration();

        return account;
    }

    @Override
    public Account getPendingAccountById(Long accountId) {

        Account account = accountRepository.findByAccountId(accountId);

        if(account == null){
            // TODO : account 존재하지 않는다는 예외 throw
            return null;
        }

        if(account.getStatus() != State.PENDING){
            // TODO : 해당 어카운트는 문제 PENDING 상태가 아니라는 예외 throw
            return null;
        }

        return account;
    }


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

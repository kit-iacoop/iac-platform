package com.web.service.Impl;

import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import com.web.dto.AccountRolesDto;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void createAccount(Account account) {
        accountRepository.encryptedSave(account);
    }

    @Transactional
    @Override
    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Account getAccountById(Long id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isEmpty()){
            return null;
        }

        return optionalAccount.get();
    }

    @Transactional
    @Override
    public AccountRolesDto getAccountRolesDtoById(Long id) {

        Account account = getAccountById(id);

        if(account == null) {
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
    public void updateAccountRoles(AccountRolesDto accountRolesDto) {
        Account account = getAccountById(Long.parseLong(accountRolesDto.getId()));

        if(accountRolesDto.getRoles() != null){
            Set<Role> roles = new HashSet<>();

            accountRolesDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });

            account.updateRoles(roles);
        }

    }
}

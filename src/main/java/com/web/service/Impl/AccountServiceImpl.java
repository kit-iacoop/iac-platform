package com.web.service.Impl;

import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}

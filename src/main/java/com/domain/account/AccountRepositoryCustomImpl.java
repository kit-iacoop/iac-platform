package com.domain.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@Repository
@Transactional
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account encryptedSave(Account account) {
        account.changePassword(passwordEncoder.encode(account.getPassword()));

        if(account.getAccountId() == null){
            em.persist(account);

        } else{
            log.warn("encryptedSave()로는 UPDATE가 불가능합니다.");

        }

        return account;
    }

}

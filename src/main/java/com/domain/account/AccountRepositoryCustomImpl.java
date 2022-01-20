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

        if (!account.getPassword().startsWith("{bcrypt}")){ // 암호화 되어있지 않다면 암호화
            account.changePassword(passwordEncoder.encode(account.getPassword()));
        }

        if(account.getAccountId() == null){
            em.persist(account);
        } else{
            em.merge(account);
        }

        return account;
    }

}

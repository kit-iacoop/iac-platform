package com.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @Autowired
    private EntityManager em;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void encryptedSave(Account account){
        account.changePassword(passwordEncoder.encode(account.getPassword()));
        em.persist(account);
    }

}

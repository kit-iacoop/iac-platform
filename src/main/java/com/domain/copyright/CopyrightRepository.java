package com.domain.copyright;

import com.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CopyrightRepository extends JpaRepository<Copyright, Long> {
    List<Copyright> findByAccountId(Account accountId);
}

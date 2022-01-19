package com.domain.copyright;

import com.domain.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CopyrightRepository extends JpaRepository<Copyright, Long> {
    List<Copyright> findByAccountId(Account accountId, Pageable pageable);

    Page<Copyright> findAll(Pageable pageable);

    Page<Copyright> findByTitleContaining(Pageable pageable, String title);

}

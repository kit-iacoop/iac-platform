package com.domain.Item;

import com.domain.Account.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByCompany(Company company);
}

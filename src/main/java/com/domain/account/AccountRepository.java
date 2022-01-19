package com.domain.account;
import com.web.dto.PendingCompanyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {
    Account findByLoginId(String loginId);

    @Query("select new com.web.dto.PendingCompanyDTO(c.accountId, c.name, c.companyType, c.sector) from Company c where c.status = 'PENDING'")
    List<PendingCompanyDTO> getAllPendingCompanies();
}

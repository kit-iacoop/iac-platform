package com.domain.CollaboRequest;

import com.domain.Account.Officer;
import com.domain.common.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestRepository extends JpaRepository<CollaboRequest, Long> {

    List<CollaboRequest> findByOfficer(Officer officer);

    List<CollaboRequest> findByOfficerAndStatus(Officer officer, State status);
}

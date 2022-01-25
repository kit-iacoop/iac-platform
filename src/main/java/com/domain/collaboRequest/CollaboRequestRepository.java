package com.domain.collaboRequest;

import com.domain.account.Officer;
import com.domain.common.RequestType;
import com.domain.common.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaboRequestRepository extends JpaRepository<CollaboRequest, Long> {

    Page<CollaboRequest> findByOfficer(Officer officer, Pageable pageable);

    List<CollaboRequest> findByOfficerAndStatus(Officer officer, State status);

    Page<CollaboRequest> findAllByTitleContains(String key, Pageable pageable);

    Page<CollaboRequest> findAllByRequestTypeAndTitleContains(RequestType requestType, String key, Pageable pageable);

    Page<CollaboRequest> findAllByCompany_AccountIdAndTitleContains(Long companyId, String key, Pageable pageable);

    Page<CollaboRequest> findAllByIsCapstoneAndTitleContains(String isCapstone, String key, Pageable pageable);
}

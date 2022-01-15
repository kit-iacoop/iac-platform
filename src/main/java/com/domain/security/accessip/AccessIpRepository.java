package com.domain.security.accessip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {

    AccessIp findByIpAddress(String IpAddress);
}
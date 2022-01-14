package com.domain.security.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findByResourceNameAndHttpMethod(String resourceName, String httpMethod);

    @Query("select r from Resource r join fetch r.roleSet where r.resourceType = 'url' order by r.orderNum desc")
    List<Resource> findAllResources();

    @Query("select r from Resource r join fetch r.roleSet where r.resourceType = 'method' order by r.orderNum desc")
    List<Resource> findAllMethodResources();

    @Query("select r from Resource r join fetch r.roleSet where r.resourceType = 'pointcut' order by r.orderNum desc")
    List<Resource> findAllPointcutResources();
}
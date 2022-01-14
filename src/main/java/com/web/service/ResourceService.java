package com.web.service;

import com.domain.security.resource.Resource;

import java.util.List;

public interface ResourceService {

    Resource getResource(long id);

    List<Resource> getResource();

    void createResource(Resource Resources);

    void deleteResource(long id);
}
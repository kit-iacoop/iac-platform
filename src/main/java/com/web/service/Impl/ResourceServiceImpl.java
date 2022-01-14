package com.web.service.Impl;


import com.domain.security.resource.Resource;
import com.domain.security.resource.ResourceRepository;
import com.web.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Transactional
    public Resource getResource(long id) {
        return resourceRepository.findById(id).orElse(new Resource());
    }

    @Transactional
    public List<Resource> getResource() {
        return resourceRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Transactional
    public void createResource(Resource resource){
        resourceRepository.save(resource);
    }

    @Transactional
    public void deleteResource(long id) {
        resourceRepository.deleteById(id);
    }
}
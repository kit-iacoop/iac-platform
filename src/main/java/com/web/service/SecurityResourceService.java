package com.web.service;



import com.domain.security.accessip.AccessIpRepository;
import com.domain.security.resource.Resource;
import com.domain.security.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


//DB로부터 자원을 가져와서 매핑
@Service
public class SecurityResourceService {


    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private AccessIpRepository accessIpRepository;


    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList(){

        /* 권한과 자원정보 가져와 매핑 */
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resource> resourceList = resourceRepository.findAllResources();

        resourceList.forEach(resource -> {
           List<ConfigAttribute> configAttributeList = new ArrayList<>();

           resource.getRoleSet().forEach(role -> {
              configAttributeList.add(new SecurityConfig(role.getRoleName()));
           });
            result.put(new AntPathRequestMatcher(resource.getResourceName()), configAttributeList);

        });

        return result;
    }

    public Boolean doesIpAddressExist(String ipAddress){
        return accessIpRepository.findByIpAddress(ipAddress) != null;
    }
}

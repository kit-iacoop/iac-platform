package com.listener;

import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.account.Admin;
import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
import com.domain.security.resource.Resource;
import com.domain.security.resource.ResourceRepository;
import com.domain.security.role.Role;
import com.domain.security.role.RoleRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;


@Setter
@ConfigurationProperties(prefix = "property.default-data-loader")
@Component
public class DefaultDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean activate = false; // application.yml에 의해 주입됨

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        if(activate){
            loadRoleData();
            loadAccountData();
            loadResourceData();
        }

    }

    private void loadRoleData() {
        createRoleIfNotFound("ROLE_ADMIN", "어드민 권한");
        createRoleIfNotFound("ROLE_COMPANY", "회사 권한");
    }

    public void loadAccountData(){
        createAdminIfNotFound("ADMIN", "1234");
        createCompanyIfNotFound("COMPANY0", "1234");
    }

    private void loadResourceData() {
        createResourceIfNotFound(0L, "/*", "url", "", 1000, "ROLE_USER", "ROLE_ADMIN", "ROLE_COMPANY" );
        createResourceIfNotFound(1L, "/admin/*", "url", "", 0, "ROLE_ADMIN");
    }


    private Role createRoleIfNotFound(String roleName, String roleDesc) {

        // 중복 검사
        Role role = roleRepository.findByRoleName(roleName);
        if(role != null){
            return role;
        }


        // 생성
        role = Role.builder()
                .roleName(roleName)
                .roleDesc(roleDesc)
                .build();

        return roleRepository.save(role);
    }


    private Resource createResourceIfNotFound(Long id, String name, String type, String httpMethod, Integer priority, String... roleNames) {

        // 중복 검사
        Resource resource = resourceRepository.findByResourceNameAndHttpMethod(name, httpMethod);
        if(resource != null){
            return resource;
        }

        // 자원 생성
        resource = Resource.builder()
                .id(id)
                .resourceName(name)
                .resourceType(type)
                .httpMethod(httpMethod)
                .orderNum(priority)
                .build();

        for(String roleName : roleNames){
            Role role = roleRepository.findByRoleName(roleName);
            if(role != null){
                resource.addRole(role);
            }
        }

        return resourceRepository.save(resource);
    }



    @Transactional
    public Admin createAdminIfNotFound(final String loginId, final String password){

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);
        if (account != null) {
            return (Admin) account;
        }

        // 생성
        account = Admin.builder()
                .name("Admin")
                .birthDate(LocalDate.now())
                .address(new Address(" ", " ", 0L))
                .loginId(loginId)
                .password(password)
                .email(" ")
                .telephone(" ")
                .status(State.NORMAL)
                .build();

        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
        account.addRole(role);

        return (Admin) account;
    }

    @Transactional
    public Company createCompanyIfNotFound(final String loginId, final String password) {

        // 중복 검사
        Account account = accountRepository.findByLoginId(loginId);

        if (account != null) {
            return (Company) account;
        }


        // 생성
        account = Company.builder()
                .name("test company name")
                .birthDate(LocalDate.now())
                .address(new Address("test city", "test street", 123456L))
                .loginId(loginId)
                .password(password)
                .email("test@test.com")
                .telephone("010-0000-0000")
                .status(State.NORMAL)
                .businessRegistrationNumber(123456789L)
                .employeeNumber(1234L)
                .sector("섹터섹터섹터")
                .owner("test owner")
                .grade("test grade")
                .companyType("test company type")
                .temporaryAddress("test temporary address")
                .mileage(123456L)
                .point(123456L)
                .subscriptionDate(LocalDate.now())
                .currentizationStatus(State.NORMAL)
                .build();


        account = accountRepository.encryptedSave(account);

        Role role = roleRepository.findByRoleName("ROLE_COMPANY");
        account.addRole(role);


        return (Company) account;
    }

}
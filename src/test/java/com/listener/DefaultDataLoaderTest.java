package com.listener;

import com.domain.account.AccountRepository;
import com.domain.account.Admin;
import com.domain.account.Company;

import com.domain.common.State;

import com.domain.security.resource.Resource;
import com.domain.security.resource.ResourceRepository;
import com.domain.security.role.Role;

import com.domain.security.role.RoleRepository;
import com.web.controller.HomeController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DefaultDataLoaderTest { //TODO : 테스트 코드 최신화

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private DefaultDataLoader defaultDataLoader;


    @Nested
    @DisplayName("계정 관련 데이터")
    class loadAccountData{

        @Test
        @DisplayName("Company 엔티티 삽입")
        public void createCompanyIfNotFoundTest() {

            //given
            String loginId = "COMPANY0";
            String password = "1234";
            Role role = Role.builder()
                    .roleName("ROLE_COMPANY")
                    .roleDesc("회사 권한")
                    .build();

            when(roleRepository.findByRoleName(role.getRoleName())).thenReturn(role);
            when(accountRepository.findByLoginId(loginId)).thenReturn(null);
            when(accountRepository.encryptedSave(any(Company.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
//
//            //when
//            Company company = defaultDataLoader.createCompanyIfNotFound(loginId, password);
//
//            //then
//            assertEquals(loginId, company.getLoginId());
//            assertEquals(password, company.getPassword());


        }

        @Test
        @DisplayName("Admin 엔티티 삽입")
        public void createAdminIfNotFoundTest() {
            //given
            String loginId = "ADMIN";
            String password = "1234";
            Role role = Role.builder()
                    .roleName("ROLE_ADMIN")
                    .roleDesc("어드민 권한")
                    .build();

            when(roleRepository.findByRoleName(role.getRoleName())).thenReturn(role);
            when(accountRepository.findByLoginId(loginId)).thenReturn(null);
            when(accountRepository.encryptedSave(any(Admin.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());


            //when
            Admin admin = defaultDataLoader.createAdminIfNotFound(loginId, password);

            //then
            assertEquals(loginId, admin.getLoginId());
            assertEquals(password, admin.getPassword());


        }
    }


    @Nested
    @DisplayName("시큐리티 관련 데이터")
    class loadSecurityData {

        @Test
        @DisplayName("Role 삽입")
        public void createRoleIfNotFoundTest() {

            //given
            String roleName = "ROLE_ADMIN";
            String roleDesc = "어드민 권한";

            when(roleRepository.findByRoleName(roleName)).thenReturn(null);
            when(roleRepository.save(any(Role.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

            //when
            Role role = defaultDataLoader.createRoleIfNotFound(roleName, roleDesc);

            //then
            assertEquals(roleName, role.getRoleName());
            assertEquals(roleDesc, role.getRoleDesc());

        }


        @Test
        @DisplayName("Resource 삽입")
        public void createResourceIfNotFound() {

            //given
            Long id = 0L;
            String name = "/*";
            String type = "url";
            String httpMethod = "";
            Integer priority = 1000;
            String[] roleNames = {"ROLE_COMPANY", "ROLE_ADMIN"};
            Role role = Role.builder()
                    .roleName("ROLE_ADMIN")
                    .roleDesc("어드민 권한")
                    .build();

            when(resourceRepository.findByResourceNameAndHttpMethod(name, httpMethod)).thenReturn(null);
            when(resourceRepository.save(any(Resource.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
            when(roleRepository.findByRoleName(role.getRoleName())).thenReturn(role);

            //when

            defaultDataLoader.createResourceIfNotFound(name, type, httpMethod, priority, roleNames);

        }
    }


}

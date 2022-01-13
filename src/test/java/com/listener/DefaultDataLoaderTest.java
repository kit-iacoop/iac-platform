package com.listener;

import com.domain.account.AccountRepository;
import com.domain.account.Company;
import com.web.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
public class DefaultDataLoaderTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private DefaultDataLoader defaultDataLoader;


    @Nested
    @DisplayName("계정 관련 데이터")
    class loadAccountData{

        @Test
        @DisplayName("회사 엔티티 삽입")
        public void createCompanyIfNotFound() {

            //given
            String loginId = "COMPANY0";
            String password = "1234";

            when(accountRepository.findByLoginId(loginId)).thenReturn(null);
            when(accountRepository.encryptedSave(any(Company.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

            //when
            Company company = (Company)defaultDataLoader.createCompanyIfNotFound(loginId, password);

            //then
            assertEquals(loginId, company.getLoginId());
            assertEquals(password, company.getPassword());


        }

    }


}

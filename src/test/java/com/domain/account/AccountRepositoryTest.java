package com.domain.account;

import com.config.TestConfig;
import com.domain.common.Address;
import com.domain.common.State;
import com.listener.DefaultDataLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestConfig.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Nested
    @DisplayName("Company")
    class CompanyTest {

        @Test
        @DisplayName("Company 객체 pw 암호화 저장 & loginId를 통한 조회")
        public void encryptedSaveAndFindByLoginId() {

            //given
            String loginId = "COMPANY0";
            String password = "1234";

            Company account = Company.builder()
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

            //when
            accountRepository.encryptedSave(account);
            Company foundAccount = (Company) accountRepository.findByLoginId(loginId);


            //then

            //암호화 체크
            assertNotEquals(password, foundAccount.getPassword());

            //데이터 체크
            assertEquals(foundAccount.getLoginId(), account.getLoginId());
            assertEquals(foundAccount.getName(), account.getName());
            assertEquals(foundAccount.getBirthDate(), account.getBirthDate());

            assertEquals(foundAccount.getEmail(), account.getEmail());
            assertEquals(foundAccount.getTelephone(), account.getTelephone());
            assertEquals(foundAccount.getStatus(), account.getStatus());
            assertEquals(foundAccount.getBusinessRegistrationNumber(), account.getBusinessRegistrationNumber());
            assertEquals(foundAccount.getEmployeeNumber(), account.getEmployeeNumber());
            assertEquals(foundAccount.getSector(), account.getSector());
            assertEquals(foundAccount.getOwner(), account.getOwner());
            assertEquals(foundAccount.getGrade(), account.getGrade());
            assertEquals(foundAccount.getCompanyType(), account.getCompanyType());
            assertEquals(foundAccount.getTemporaryAddress(), account.getTemporaryAddress());
            assertEquals(foundAccount.getMileage(), account.getMileage());
            assertEquals(foundAccount.getPoint(), account.getPoint());
            assertEquals(foundAccount.getSubscriptionDate(), account.getSubscriptionDate());
            assertEquals(foundAccount.getCurrentizationStatus(), account.getCurrentizationStatus());


        }


    }

}

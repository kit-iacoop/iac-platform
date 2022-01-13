package com.listener;

import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.account.Company;
import com.domain.common.Address;
import com.domain.common.State;
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


    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        if(activate){
            loadAccountData();
        }

    }


    public void loadAccountData(){
        createCompanyIfNotFound("COMPANY0", "1234");
    }


    @Transactional
    public void createCompanyIfNotFound(final String loginId, final String password) {

        Account account = accountRepository.findByLoginId(loginId);

        if (account == null) {

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

            accountRepository.encryptedSave(account);
        }


    }

}
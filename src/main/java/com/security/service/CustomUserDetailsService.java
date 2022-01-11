package com.security.service;


import com.domain.account.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Account account = accountRepository.findByLoginId(loginId);

        // id 찾지 못하는 예외
        if(account == null){
            throw new UsernameNotFoundException("LoginIDNotFoundException");
        }

        List<GrantedAuthority> roles = new ArrayList<>();


        /* 권한 부여 임시 코드 *///TODO: 권한 관련 DB화

        String auth = "";

        if(account instanceof Company)
            auth = "ROLE_COMPANY";
        else if(account instanceof Officer)
            auth = "ROLE_OFFICER";
        else if(account instanceof Student)
            auth = "ROLE_STUDENT";
        else if(account instanceof Professor)
            auth = "ROLE_PROFESSOR";
        else if(account instanceof Admin)
            auth = "ROLE_ADMIN";

        roles.add(new SimpleGrantedAuthority(auth));

        return new AccountContext(account, roles);
    }
}

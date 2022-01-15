package com.security.service;


import com.domain.account.*;
import com.domain.security.role.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor

@Slf4j
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Transactional
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Account account = accountRepository.findByLoginId(loginId);

        // 해당 loginId 가지는 유저 미존재의 경우
        if(account == null){
            throw new UsernameNotFoundException("No user found with LoginId: " + loginId);
        }


        // 인가 프로세스에서 사용할 수 있도록 유저 권한 가공
        List<GrantedAuthority> roles = account.getAccountRoles()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet())
                .stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new AccountContext(account, roles);
    }
}

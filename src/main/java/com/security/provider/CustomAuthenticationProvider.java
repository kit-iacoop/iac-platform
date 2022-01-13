package com.security.provider;

import com.security.service.AccountContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String)authentication.getCredentials();


        //id 검증
        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(username);

        // pw 검증
        if(!passwordEncoder.matches(password, accountContext.getPassword())){
            throw new BadCredentialsException("BadCredentialsException");
        }

        accountContext.getAccount().deletePassword(); // 보안을 위해 PW 삭제

        /* 여기서 추가 검증 절차 진행 가능 */

        // 인증 토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        accountContext.getAccount(), null, accountContext.getAuthorities()
                );

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

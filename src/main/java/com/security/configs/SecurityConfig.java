package com.security.configs;


import com.security.handler.CustomAccessDeniedHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Slf4j

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();


        http
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll();

        http
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler());


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //정적 파일 ignore
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        CustomAccessDeniedHandler accessDeniedHandler = new CustomAccessDeniedHandler();
        accessDeniedHandler.setErrorPage("/denied");
        return accessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

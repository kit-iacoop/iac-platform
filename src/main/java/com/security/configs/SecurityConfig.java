package com.security.configs;


import com.security.factory.UrlResourceMapFactoryBean;
import com.security.filter.PermitAllFilter;
import com.security.handler.CustomAccessDeniedHandler;
import com.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import com.security.provider.CustomAuthenticationProvider;
import com.web.service.SecurityResourceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
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
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Slf4j

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //White List
    private final String[] PERMIT_ALL_RESOURCES = {"/", "/login", "/register/**"};

    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final SecurityResourceService securityResourceService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
            .and()
                .addFilterAt(customFilterSecurityInterceptor(), FilterSecurityInterceptor.class) // 인가 필터 재정의
        ;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        //custom provider 등록
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    public void configure(WebSecurity web) {
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


    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }


    /* 인가 DB 연동 관련 빈들 */
    @Bean // 인가 담당 필터 교체 (우리는 DB연동하여 인가수행하므로)
    public PermitAllFilter customFilterSecurityInterceptor() throws Exception {

        PermitAllFilter permitAllFilter = new PermitAllFilter(PERMIT_ALL_RESOURCES);

        permitAllFilter.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource()); // 메타데이터 소스 재정의
        permitAllFilter.setAccessDecisionManager(affirmativeBased()); // decision 정책 설정 (affirmativeBased : 하나라도 긍정이면 접근허가)
        permitAllFilter.setAuthenticationManager(authenticationManagerBean()); // 인증된 사용자인지 확인 필요하기에

        return permitAllFilter;
    }

    @Bean // 인가 담당 필터 교체 시 서블릿에도 자동으로 등록이 되기에 비활성화해주어야 한다.
    public FilterRegistrationBean filterRegistrationBean() throws Exception {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(customFilterSecurityInterceptor());
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean
    public AccessDecisionManager affirmativeBased() {
        return new AffirmativeBased(getAccessDecisionVoters());
    }

    private List<AccessDecisionVoter<?>> getAccessDecisionVoters() {
        //메모리 절약을 위해서 요소가 없거나(empty) 하나인 경우에는 Collections.emptyList() 또는 Collections.singletonList()를 사용
        return Collections.singletonList(new RoleVoter());
    }

    @Bean
    public UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource(){
        return new UrlFilterInvocationSecurityMetadataSource(urlResourcesMapFactoryBean().getObject(), securityResourceService);
    }

    @Bean
    public UrlResourceMapFactoryBean urlResourcesMapFactoryBean() {
        UrlResourceMapFactoryBean urlResourcesMapFactoryBean = new UrlResourceMapFactoryBean();
        urlResourcesMapFactoryBean.setSecurityResourceService(securityResourceService);
        return urlResourcesMapFactoryBean;
    }



    /* end */

}

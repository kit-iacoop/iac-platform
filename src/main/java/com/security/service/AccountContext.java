package com.security.service;


import com.domain.account.Account;
import com.domain.security.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;


public class AccountContext extends User {

    private final String ROLE_PREFIX = "ROLE_";
    private final Account account;

    public AccountContext(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getLoginId(), account.getPassword(), authorities);
        this.account = account;

    }

    public Account getAccount() {
        return account;
    }

    public Boolean hasRole(String roleName){

        roleName = ROLE_PREFIX + roleName;

        for(GrantedAuthority role : getAuthorities()){
            if(role.getAuthority().equals(roleName)){
                return true;
            }
        }

        return false;
    }


}




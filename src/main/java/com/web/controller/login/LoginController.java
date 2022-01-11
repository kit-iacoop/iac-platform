package com.web.controller.login;

import com.domain.account.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){

        return "login/logIn";
    }

    @GetMapping("/denied")
    public String accessDenied(@RequestParam(value = "exception", required = false) String exception, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getPrincipal() != null){
            Account principal = (Account)auth.getPrincipal();
            model.addAttribute("username", principal.getName());
        }

        model.addAttribute("exception", exception);

        return "/login/denied";
    }


}

package com.web.controller.account;


import com.domain.account.Company;
import com.domain.common.State;
import com.web.dto.CompanyRegisterDTO;
import com.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor

@Controller
public class AccountController {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping( "/register")
    public String register() {
        return "register/main";
    }

    @GetMapping("/register/company")
    public ModelAndView createCompany(){
        return new ModelAndView("register/company").addObject(new CompanyRegisterDTO());
    }

    @PostMapping("/register/company")
    public String createCompany(@ModelAttribute CompanyRegisterDTO companyDTO){

        try {
            Company companyEntity = companyDTO.toEntity();
            companyEntity.verification("BRONZE", 0L, 0L, State.NORMAL); //TODO : 가입 승인 페이지 생길 때 까지..
            accountService.createAccount(companyEntity);

        } catch(NumberFormatException NFE){
            // FE에서 입력 값 예외처리 해줄 것으로 생각.
            // -> 정상적인 접근이라면 이곳으로 오면 안된다.

            return "register/company"; // 임시 코드
            //FE 예외처리 코드 생기면 아래로 return 코드 대체
            //return "redirect:/denied?exception=invalid request
        }
        //TODO : 회원가입 완료 페이지 필요
        return "redirect:/";
    }


}

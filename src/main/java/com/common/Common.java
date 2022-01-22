package com.common;

import com.security.service.AccountContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@Component
public class Common {

    public LinkedList<LinkedHashMap<String, String>> refineErrors(Errors errors) {
        LinkedList<LinkedHashMap<String, String>> errorList = new LinkedList<>();
        errors.getFieldErrors().forEach(e-> {
            LinkedHashMap<String, String> error = new LinkedHashMap<>();
            error.put(e.getField(), e.getDefaultMessage());
            errorList.push(error);
        });
        return errorList;
    }
    public AccountContext getAccountContext(){
        return (AccountContext)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String getReqUrlPrefix(HttpServletRequest request){

        String uri = request.getRequestURI();

        if(uri.startsWith("officer"))
            return "officer";
        else if(uri.startsWith("company"))
            return "company";
        else if(uri.startsWith("professor"))
            return "professor";


        return null;
    }
}

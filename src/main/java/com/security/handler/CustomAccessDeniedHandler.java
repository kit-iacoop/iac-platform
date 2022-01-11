package com.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {

        String deniedUrl = errorPage + "?exception=" + e.getMessage();
        res.sendRedirect(deniedUrl);
    }

    public void setErrorPage(String errorPage){
        this.errorPage = errorPage;
    }

}

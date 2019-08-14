package com.ducanh.duan.controller;

import com.ducanh.duan.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AccountService accService;


    @GetMapping
    public String adminPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        System.out.println(accService.findAccountOrderByCreatedAtAndActive());
        return "admin";
    }
}

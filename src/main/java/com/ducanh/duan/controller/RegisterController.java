package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.RegisterAccountVM;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String registerPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken) {
            model.addAttribute("registerAccountVM", new RegisterAccountVM());
            return "register";
        } else {
            return "redirect:/user";
        }
    }

    @PostMapping
    public String doRegistration(@Valid @ModelAttribute RegisterAccountVM registerAccountVM, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        Account acc = accountService.saveAccount(registerAccountVM, bindingResult);

        if (acc == null) {
            return "register";
        }
        return "redirect:/login?registration_success=true";
    }
}

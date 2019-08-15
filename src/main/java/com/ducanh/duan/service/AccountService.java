package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.RegisterAccountVM;
import com.ducanh.duan.model.Account;
import org.springframework.validation.BindingResult;

import java.text.ParseException;

public interface AccountService {
    Account saveAccount(RegisterAccountVM acc, BindingResult bindingResult) throws ParseException;
    Account findAccountByUsername(String username);
}

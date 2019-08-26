package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.RegisterAccountVM;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.model.AccountRole;
import com.ducanh.duan.model.Role;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.AccountRoleRepository;
import com.ducanh.duan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static String urlAvatar = "/img/icon_default_user1.png";

    @Override
    public Account saveAccount(RegisterAccountVM acc, BindingResult bindingResult) throws ParseException {
        Account accountSelect = accountRepository.findByUserName(acc.getUsername());
        if (accountSelect != null) {
            bindingResult.addError(new FieldError("registerAccountVM", "username", "Tên đăng nhập đã tồn tại"));
            return null;
        }

        Account accountInsert = new Account();
        accountInsert.setUserName(acc.getUsername());
        accountInsert.setPassword(passwordEncoder.encode(acc.getPassword()).toString());
        accountInsert.setCreatedAt(new Date());
        accountInsert.setBirthday(simpleDateFormat.parse(acc.getBirthDay()));
        accountInsert.setActive(true);
        accountInsert.setDisplayName(acc.getFullName());
        accountInsert.setUrlAvatar(urlAvatar);
        accountInsert.setTinh(acc.getTinh());

        accountRepository.save(accountInsert);

        Role role = roleRepository.findByRoleName("USER");

        AccountRole accRole = new AccountRole();
        accRole.setAccountId(accountInsert.getAccountId());
        accRole.setRoleId(role.getRoleId());
        accountRoleRepository.save(accRole);

        return accountInsert;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return null;
    }
}

package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.LockOrUnlockAccVM;
import com.ducanh.duan.dto.GetListAllAccountDTO;
import com.ducanh.duan.dto.LockOrUnlockAccDTO;
import com.ducanh.duan.service.AccountService;
import com.ducanh.duan.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String adminPage(Model model) {

        List<GetListAllAccountDTO> dataListUser = adminService.findAllAccount();

        model.addAttribute("listUser", dataListUser);

        return "admin";
    }

    @PostMapping("/lock-or-unlock-acc")
    @ResponseBody
    public ResponseEntity<LockOrUnlockAccDTO> doLockOrUnlock(@RequestBody LockOrUnlockAccVM lockOrUnlockAccVM) {
        return adminService.lockOrUnlockAccount(lockOrUnlockAccVM);
    }
}

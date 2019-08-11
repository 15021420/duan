package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String defaultPage(Model model) throws SQLException {
        model.addAttribute("createNewPostVM", new CreateNewPostVM());
        userService.initUser(model);
        return "user";
    }
}

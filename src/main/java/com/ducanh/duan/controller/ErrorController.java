package com.ducanh.duan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ErrorController {

    @GetMapping("/access-denied")
    @ResponseBody
    public String error401() {
        return "access denied";
    }
}

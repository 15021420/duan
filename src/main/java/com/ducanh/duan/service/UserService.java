package com.ducanh.duan.service;

import org.springframework.ui.Model;

import java.sql.SQLException;

public interface UserService {
    void initUser(Model model) throws SQLException;
}

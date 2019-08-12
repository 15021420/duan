package com.ducanh.duan.service;

import com.ducanh.duan.dto.UserBasicInfo;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private Object data;

    @Override
    public void initUser(Model model) throws SQLException {
        List<Object[]> dataResult = userRepository.findBasicInfoUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        if (!dataResult.isEmpty()) {
            userBasicInfo.setFullName(String.valueOf(dataResult.get(0)[0]));
            userBasicInfo.setBirthDay(String.valueOf(dataResult.get(0)[1]));
            userBasicInfo.setLocation(String.valueOf(dataResult.get(0)[2]));
        }
        model.addAttribute("userInfo", userBasicInfo);
    }


}

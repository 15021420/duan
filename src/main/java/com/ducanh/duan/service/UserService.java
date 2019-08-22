package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.ChangeAvatarVM;
import com.ducanh.duan.dto.UserBasicInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void initFriend(Model model, int accountId) throws Exception;

    void initUser(Model model) throws SQLException;

    ResponseEntity<Object> changeAvatar(ChangeAvatarVM changeAvatarVM) throws IOException;

    List<String> getAllImageOfUser();

    void getNotify(Model model);

    ResponseEntity<Object> changeStatusCheckNotify();

    List<UserBasicInfoDTO> getListFriendOfUser();
}

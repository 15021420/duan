package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.ChangeAvatarVM;
import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.dto.SinglePostOfUserDTO;
import com.ducanh.duan.service.PostService;
import com.ducanh.duan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping
    public String defaultPage(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin";
        }
        model.addAttribute("createNewPostVM", new CreateNewPostVM());
        userService.initUser(model);
        GetAllPostOfUserDTO getAllPostOfUserDTO = postService.getPostOfUser();
        model.addAttribute("listPost", getAllPostOfUserDTO.getPostOfUserDTOList());
        return "user";
    }

    @GetMapping("/setting")
    public String settingPage(Model model) {
        model.addAttribute("albumImage", userService.getAllImageOfUser());
        return "user_setting";
    }

    @PostMapping("/change-avatar")
    @ResponseBody
    public ResponseEntity<Object> changeAvatar(@ModelAttribute ChangeAvatarVM changeAvatarVM) throws IOException {
        return userService.changeAvatar(changeAvatarVM);
    }

    @GetMapping("/notify")
    public String getNotify(Model model) {
        userService.getNotify(model);
        return  "notify";
    }

    @PostMapping("/notify-set-checked")
    @ResponseBody
    public ResponseEntity<Object> changeStatusCheckNotify() {
        return userService.changeStatusCheckNotify();
    }

    @GetMapping("/list-friend")
    public String pageListFriend(Model model) {
        model.addAttribute("userBasicInfoDTOList", userService.getListFriendOfUser());
        return "list_friend";
    }
}

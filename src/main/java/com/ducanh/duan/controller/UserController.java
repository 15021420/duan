package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.dto.SinglePostOfUserDTO;
import com.ducanh.duan.service.PostService;
import com.ducanh.duan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("createNewPostVM", new CreateNewPostVM());
        userService.initUser(model);
        GetAllPostOfUserDTO getAllPostOfUserDTO = postService.getPostOfUser();
        model.addAttribute("listPost", getAllPostOfUserDTO.getPostOfUserDTOList());
        for (SinglePostOfUserDTO data : getAllPostOfUserDTO.getPostOfUserDTOList()) {
            log.debug("data Post: {}", data);
        }
        return "user";
    }
}

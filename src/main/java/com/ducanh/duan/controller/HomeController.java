package com.ducanh.duan.controller;

import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.service.PostService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PostService postService;

    @GetMapping
    public String defaultPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return "index";
        } else {
            return "redirect:/news-feed";
        }

    }

    @GetMapping("/news-feed")
    public String newsFeedPage(Model model) {
        GetAllPostOfUserDTO getAllPostOfUserDTO = postService.getPostOfFriend();
        model.addAttribute("listPost", getAllPostOfUserDTO.getPostOfUserDTOList());
        return "news_feed";
    }
}

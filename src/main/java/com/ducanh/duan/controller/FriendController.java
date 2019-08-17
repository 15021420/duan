package com.ducanh.duan.controller;

import com.ducanh.duan.dto.DataSearchFriendDTO;
import com.ducanh.duan.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/search")
    public String pageSearch(@RequestParam(name = "q") String paramSearch, Model model) {
        List<DataSearchFriendDTO> dataResponse = friendService.searchFriendByUsername(paramSearch);
        model.addAttribute("listDataSearch", dataResponse);
        return "searchFriend";
    }
}

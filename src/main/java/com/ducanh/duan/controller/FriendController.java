package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.AddFriendVM;
import com.ducanh.duan.controller.vm.RemoveAddFriendVM;
import com.ducanh.duan.controller.vm.RequestAddFriendVM;
import com.ducanh.duan.controller.vm.UnfriendVM;
import com.ducanh.duan.dto.DataSearchFriendDTO;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.service.FriendService;
import com.ducanh.duan.service.PostService;
import com.ducanh.duan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {

    private Logger log = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/search")
    public String pageSearch(@RequestParam(name = "q") String paramSearch, Model model) {
        List<DataSearchFriendDTO> dataResponse = friendService.searchFriendByUsername(paramSearch);
        model.addAttribute("listDataSearch", dataResponse);
        return "searchFriend";
    }

    @PostMapping("/request-add-friend")
    @ResponseBody
    public ResponseEntity<Object> requestAddFriend(@RequestBody RequestAddFriendVM requestAddFriendVM) {
        return friendService.addRequestAddFriend(requestAddFriendVM);
    }

    @PostMapping("/remove-request-add-friend")
    @ResponseBody
    public ResponseEntity<Object> removeAddFriend(@RequestBody RemoveAddFriendVM removeAddFriendVM) {
        return friendService.removeAddFriendVM(removeAddFriendVM);
    }

    @PostMapping("/unfriend")
    @ResponseBody
    public ResponseEntity<Object> doUnfriend(@RequestBody UnfriendVM unfriendVM) {
        return friendService.unFriend(unfriendVM);
    }

    @PostMapping("/add-friend")
    public ResponseEntity<Object> addFriend(@RequestBody AddFriendVM addFriendVM) {
        return friendService.addFriend(addFriendVM);
    }

    @GetMapping("/myfriend/{accountId}")
    public String friendPage(@PathVariable(name = "accountId") int accountId, Model model) throws Exception {
        userService.initFriend(model, accountId);
        GetAllPostOfUserDTO getAllPostOfUserDTO = postService.getPostOfFriend();
        model.addAttribute("listPost", getAllPostOfUserDTO.getPostOfUserDTOList());
        return "friend_page";
    }
}

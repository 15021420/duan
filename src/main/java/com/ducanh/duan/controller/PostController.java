package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private Logger log = LoggerFactory.getLogger(PostController.class);

    @PostMapping("/create")
    public void createNewPost(@RequestBody CreateNewPostVM createNewPostVM) {
        log.debug("createNewPostVM: {}", createNewPostVM);
    }
}

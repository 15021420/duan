package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.model.Post;
import com.ducanh.duan.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/post")
public class PostController {

    private Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> createNewPost(@ModelAttribute CreateNewPostVM createNewPostVM) {
        try {
            Post post = postService.savePost(createNewPostVM);
            new ResponseEntity<Object>(post.getPostId() , HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }
}

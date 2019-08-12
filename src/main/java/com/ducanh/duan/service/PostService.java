package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.model.Post;

import java.io.IOException;
import java.util.List;

public interface PostService {
    Post savePost(CreateNewPostVM createNewPostVM) throws IOException;
    List<Post> getAllPost(int userId);
    Post getOnePost(int userId, int postId);
    GetAllPostOfUserDTO getPostOfUser();
}

package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.CreateCommentOfPostVM;
import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.controller.vm.UpdateLikeOfPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.dto.UpdateLikeOfPostDTO;
import com.ducanh.duan.model.Post;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface PostService {
    Post savePost(CreateNewPostVM createNewPostVM) throws IOException;

    List<Post> getAllPost(int userId);

    Post getOnePost(int userId, int postId);

    GetAllPostOfUserDTO getPostOfUser();

    GetAllPostOfUserDTO getPostOfUserByAccountId(int accountId);

    ResponseEntity<Object> createCommentOfPost(CreateCommentOfPostVM createCommentOfPostVM);

    ResponseEntity<UpdateLikeOfPostDTO> updateLikeOfPost(UpdateLikeOfPostVM updateLikeOfPostVM);

    GetAllPostOfUserDTO getPostOfFriend();
}

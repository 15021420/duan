package com.ducanh.duan.service;

import com.ducanh.duan.model.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPost(int userId);
    Post getOnePost(int userId, int postId);
}

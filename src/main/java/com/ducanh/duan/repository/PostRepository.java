package com.ducanh.duan.repository;

import com.ducanh.duan.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByAccountId(int accountId);
}

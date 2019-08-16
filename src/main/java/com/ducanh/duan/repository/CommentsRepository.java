package com.ducanh.duan.repository;

import com.ducanh.duan.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findByPostId(int postId);
}

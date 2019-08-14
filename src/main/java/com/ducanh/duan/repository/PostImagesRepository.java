package com.ducanh.duan.repository;

import com.ducanh.duan.model.PostImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImagesRepository extends JpaRepository<PostImages, Integer> {
    List<PostImages> findByPostId(int postId);
}

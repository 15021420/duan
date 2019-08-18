package com.ducanh.duan.repository;

import com.ducanh.duan.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
    Images findByImageId(int imageId);

    @Query(value = "SELECT pt.image_id FROM post_images pt JOIN post p ON pt.post_id = p.post_id WHERE p.post_id = ?1", nativeQuery = true)
    List<Object[]> findListImageLocationByPostId(int postId);

    @Query(value = "Select image_id from images where account_id = ?1", nativeQuery = true)
    List<Object[]> findImageIdByAccountId(int accountId);
}

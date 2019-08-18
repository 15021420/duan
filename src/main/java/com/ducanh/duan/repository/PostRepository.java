package com.ducanh.duan.repository;

import com.ducanh.duan.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByAccountIdOrderByCreatedAtDesc(int accountId);

    @Query(value = "SELECT p.* FROM post p WHERE p.account_id IN (SELECT f.account_id_2 FROM friend f WHERE f.account_id_1 = ?1)", nativeQuery = true)
    List<Object[]> findPostByFriendOfAccount(int accountId);
}

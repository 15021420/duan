package com.ducanh.duan.repository;

import com.ducanh.duan.model.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {
    UserLike findByAccountIdAndPostId(int accountId, int postId);
    int countByPostId(int postId);
}

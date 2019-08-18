package com.ducanh.duan.repository;

import com.ducanh.duan.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    Friend findByAccountId1AndAccountId2(int accId1, int accId2);
}

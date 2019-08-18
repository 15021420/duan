package com.ducanh.duan.repository;

import com.ducanh.duan.model.RequestAddFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestAddFriendRepository extends JpaRepository<RequestAddFriend, Integer> {
    RequestAddFriend findByAccountIdFromAndAccountIdTo(int accountIdFrom, int accountIdTo);
}

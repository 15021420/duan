package com.ducanh.duan.repository;

import com.ducanh.duan.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    Friend findByAccountId1AndAccountId2(int accId1, int accId2);

    @Query(value = "SELECT acc.* FROM friend f JOIN account acc ON f.account_id_1 = acc.account_id WHERE f.account_id_2 = ?1", nativeQuery = true)
    List<Object[]> getListFriendOfUserByAccountId(int accountId);
}

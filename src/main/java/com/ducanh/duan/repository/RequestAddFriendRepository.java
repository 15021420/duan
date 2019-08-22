package com.ducanh.duan.repository;

import com.ducanh.duan.model.RequestAddFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestAddFriendRepository extends JpaRepository<RequestAddFriend, Integer> {
    RequestAddFriend findByAccountIdFromAndAccountIdToOrderByCreatedAtDesc(int accountIdFrom, int accountIdTo);
    List<RequestAddFriend> findByAccountIdToAndIsCheckedOrderByCreatedAtDesc(int accountIdTo, boolean checked);

    @Query(value = "update request_add_friend set is_checked = true where account_id_to = ?1 ", nativeQuery = true)
    void setAllNotifyChecked(int accountIdTo);

    int countByAccountIdTo(int accountIdTo);
}

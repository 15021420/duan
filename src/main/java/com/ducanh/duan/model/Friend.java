package com.ducanh.duan.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "friend")
public class Friend {

    @Id
    @Column(name = "friend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int friendId;

    @Column(name = "account_id_1")
    private int accountId1;

    @Column(name = "account_id_2")
    private int accountId2;

    @Column(name = "created_at")
    private Date createdAt;

    public Friend() {
    }

    public Friend(int accountId1, int accountId2, Date createdAt) {
        this.accountId1 = accountId1;
        this.accountId2 = accountId2;
        this.createdAt = createdAt;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(int accountId1) {
        this.accountId1 = accountId1;
    }

    public int getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(int accountId2) {
        this.accountId2 = accountId2;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

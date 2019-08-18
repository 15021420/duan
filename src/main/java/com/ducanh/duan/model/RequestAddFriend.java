package com.ducanh.duan.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "request_add_friend")
public class RequestAddFriend {

    @Id
    @Column(name = "request_add_friend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestAddFriendId;

    @Column(name = "account_id_from")
    private int accountIdFrom;

    @Column(name = "account_id_to")
    private int accountIdTo;

    @Column(name = "create_at")
    private Date createdAt;

    public RequestAddFriend() {
    }

    public RequestAddFriend(int accountIdFrom, int accountIdTo, Date createdAt) {
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.createdAt = createdAt;
    }

    public int getRequestAddFriendId() {
        return requestAddFriendId;
    }

    public void setRequestAddFriendId(int requestAddFriendId) {
        this.requestAddFriendId = requestAddFriendId;
    }

    public int getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(int accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public int getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(int accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

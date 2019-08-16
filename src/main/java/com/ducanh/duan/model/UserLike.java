package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user_like")
@Table(name = "user_like", uniqueConstraints = {@UniqueConstraint(columnNames = {"account_id", "post_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLike {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

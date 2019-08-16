package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "content")
    private String content;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "username")
    private String username;
}

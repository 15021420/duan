package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "like")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

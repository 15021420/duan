package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

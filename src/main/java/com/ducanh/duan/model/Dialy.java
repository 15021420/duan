package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "dialy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dialy {

    @Id
    @Column(name = "dialy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dialyId;

    @Column(name = "image_id")
    private int imageId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

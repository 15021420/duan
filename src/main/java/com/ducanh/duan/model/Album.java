package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "album")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "hidden")
    private Boolean hidden;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

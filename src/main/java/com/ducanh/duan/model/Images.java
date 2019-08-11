package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @Column(name = "location")
    private String location;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "album_id")
    private int albumId;

    @Column(name = "hidden")
    private Boolean hidden;

    @Column(name = "create_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updatedAt;

    @Column(name = "delete_at")
    private Date deletedAt;

}

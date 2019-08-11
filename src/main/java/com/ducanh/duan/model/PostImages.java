package com.ducanh.duan.model;

import javax.persistence.*;

@Entity(name = "post_images")
public class PostImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image_id")
    private int imageId;

    @Column(name = "post_id")
    private int postId;

    public PostImages() {
    }

    public PostImages(int imageId, int postId) {
        this.imageId = imageId;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}

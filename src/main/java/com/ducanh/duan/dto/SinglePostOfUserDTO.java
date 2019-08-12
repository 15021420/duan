package com.ducanh.duan.dto;

import java.util.Date;

public class SinglePostOfUserDTO {
    private Date createdAt;

    private String postContent;

    private String[] urlImage;

    public SinglePostOfUserDTO() {
    }

    public SinglePostOfUserDTO(Date createdAt, String postContent, String[] urlImage) {

        this.createdAt = createdAt;
        this.postContent = postContent;
        this.urlImage = urlImage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String[] getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String[] urlImage) {
        this.urlImage = urlImage;
    }
}

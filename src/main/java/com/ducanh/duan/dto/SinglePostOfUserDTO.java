package com.ducanh.duan.dto;

import java.util.Date;
import java.util.List;

public class SinglePostOfUserDTO {
    private Date createdAt;

    private String postContent;

    private List<String> urlImage;

    public SinglePostOfUserDTO() {
    }

    public SinglePostOfUserDTO(Date createdAt, String postContent, List<String> urlImage) {
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

    public List<String> getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(List<String> urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "createAt: " + createdAt +"\n postContent: " + postContent +"\n urlImage: " + urlImage.size();
    }
}

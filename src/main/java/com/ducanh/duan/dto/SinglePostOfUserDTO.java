package com.ducanh.duan.dto;

import com.ducanh.duan.model.Comments;

import java.util.Date;
import java.util.List;

public class SinglePostOfUserDTO {

    private int postId;

    private Date createdAt;

    private String postContent;

    private List<Comments> postComment;

    private List<String> urlImage;

    private boolean isLikedPost;

    private int countLikedPost;

    private String displayName;

    private String urlAvatar;

    public SinglePostOfUserDTO() {
    }

    public SinglePostOfUserDTO(int postId, Date createdAt, String postContent, List<Comments> postComment, List<String> urlImage, boolean isLikedPost, int countLikedPost) {
        this.postId = postId;
        this.createdAt = createdAt;
        this.postContent = postContent;
        this.postComment = postComment;
        this.urlImage = urlImage;
        this.isLikedPost = isLikedPost;
        this.countLikedPost = countLikedPost;
    }

    public SinglePostOfUserDTO(int postId, Date createdAt, String postContent, List<Comments> postComment, List<String> urlImage, boolean isLikedPost, int countLikedPost, String displayName, String urlAvatar) {
        this.postId = postId;
        this.createdAt = createdAt;
        this.postContent = postContent;
        this.postComment = postComment;
        this.urlImage = urlImage;
        this.isLikedPost = isLikedPost;
        this.countLikedPost = countLikedPost;
        this.displayName = displayName;
        this.urlAvatar = urlAvatar;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public List<Comments> getPostComment() {
        return postComment;
    }

    public void setPostComment(List<Comments> postComment) {
        this.postComment = postComment;
    }

    public List<String> getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(List<String> urlImage) {
        this.urlImage = urlImage;
    }

    public boolean isLikedPost() {
        return isLikedPost;
    }

    public void setLikedPost(boolean likedPost) {
        isLikedPost = likedPost;
    }

    public int getCountLikedPost() {
        return countLikedPost;
    }

    public void setCountLikedPost(int countLikedPost) {
        this.countLikedPost = countLikedPost;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    @Override
    public String toString() {
        return "createAt: " + createdAt +"\n postContent: " + postContent +"\n urlImage: " + urlImage.size();
    }
}

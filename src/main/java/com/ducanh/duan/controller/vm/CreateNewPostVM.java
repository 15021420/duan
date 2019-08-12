package com.ducanh.duan.controller.vm;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

public class CreateNewPostVM {
    private MultipartFile[] imageFile;

    private String postContent;

    public CreateNewPostVM() {
    }

    public CreateNewPostVM(MultipartFile[] imageFile, String postContent) {
        this.imageFile = imageFile;
        this.postContent = postContent;
    }

    public MultipartFile[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile[] imageFile) {
        this.imageFile = imageFile;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}

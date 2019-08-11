package com.ducanh.duan.controller.vm;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

public class CreateNewPostVM {

    @Size(min = 0, max = 50000, message = "Nội dung từ 0  đến 50000 ký tự")
    private String postContent;

    public CreateNewPostVM() {
    }

    public CreateNewPostVM(@Size(min = 0, max = 50000, message = "Nội dung từ 0  đến 50000 ký tự") String postContent) {
        this.postContent = postContent;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}

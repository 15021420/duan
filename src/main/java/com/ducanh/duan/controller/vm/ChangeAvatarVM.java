package com.ducanh.duan.controller.vm;

import org.springframework.web.multipart.MultipartFile;

public class ChangeAvatarVM {
    private MultipartFile avatar;

    public ChangeAvatarVM() {
    }

    public ChangeAvatarVM(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}

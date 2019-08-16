package com.ducanh.duan.dto;

public class LockOrUnlockAccDTO {
    private String status;

    public LockOrUnlockAccDTO() {
    }

    public LockOrUnlockAccDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

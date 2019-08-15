package com.ducanh.duan.dto;

import java.util.Date;
import java.util.List;

public class GetListAllAccountDTO {

    private String username;

    private boolean active;

    private Date createdAt;

    private List<String> roleName;

    public GetListAllAccountDTO() {
    }

    public GetListAllAccountDTO(String username, boolean active, Date createdAt, List<String> roleName) {
        this.username = username;
        this.active = active;
        this.createdAt = createdAt;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(List<String> roleName) {
        this.roleName = roleName;
    }
}

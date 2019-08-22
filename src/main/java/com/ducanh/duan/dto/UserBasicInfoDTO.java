package com.ducanh.duan.dto;

import java.io.Serializable;
import java.util.Date;

public class UserBasicInfoDTO implements Serializable {
    private String accountId;
    private String fullName;
    private String birthDay;
    private String location;
    private String urlAvatar;

    public UserBasicInfoDTO() {
    }

    public UserBasicInfoDTO(String fullName, String birthDay, String location, String urlAvatar) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.location = location;
        this.urlAvatar = urlAvatar;
    }

    public UserBasicInfoDTO(String accountId, String fullName, String birthDay, String location, String urlAvatar) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.location = location;
        this.urlAvatar = urlAvatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

package com.ducanh.duan.dto;

import java.util.Date;

public class DataSearchFriendDTO {

    private String accountId;

    private String username;

    private String xa;

    private String huyen;

    private String tinh;

    private String school;

    private String urlAvatar;

    private String favorite;

    private String birthDay;

    private String displayName;

    private int statusFriend;

    public DataSearchFriendDTO() {
    }

    public DataSearchFriendDTO(String accountId, String username, String xa, String huyen, String tinh, String school, String urlAvatar, String favorite, String birthDay, String displayName, int statusFriend) {
        this.accountId = accountId;
        this.username = username;
        this.xa = xa;
        this.huyen = huyen;
        this.tinh = tinh;
        this.school = school;
        this.urlAvatar = urlAvatar;
        this.favorite = favorite;
        this.birthDay = birthDay;
        this.displayName = displayName;
        this.statusFriend = statusFriend;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getStatusFriend() {
        return statusFriend;
    }

    public void setStatusFriend(int statusFriend) {
        this.statusFriend = statusFriend;
    }
}

package com.ducanh.duan.dto;

import java.io.Serializable;
import java.util.Date;

public class UserBasicInfo implements Serializable {
    private String fullName;
    private String birthDay;
    private String location;

    public UserBasicInfo() {
    }

    public UserBasicInfo(String fullName, String birthDay, String location) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.location = location;
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
}

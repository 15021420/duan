package com.ducanh.duan.controller.vm;

import com.ducanh.duan.annotation.FieldMatch;
import com.ducanh.duan.annotation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@FieldMatch(first = "password", second = "confirmPassword", message = "Mật khẩu không khớp")
public class RegisterAccountVM implements Serializable {

    @Pattern(regexp = "^[a-z0-9-]{3,20}$",
            message = "Tên đăng nhập không hợp lệ")
    private String username;

    @Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,12})", message = "Mật khẩu không hợp lệ")
    private String password;

    private String confirmPassword;

    @ValidDate(format = "yyyy-MM-dd", message = "Ngày sinh không hợp lệ")
    private String birthDay;

    @NotEmpty(message = "Họ và tên không được trống")
    @Size(max = 50,  message = "Họ và tên không dài quá 50 ký tự")
    private String fullName;

    @NotEmpty(message = "Tỉnh không được  trống")
    @Size(max = 50, message = "Tỉnh không được dài quá 50 ký tự")
    private  String tinh;

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public RegisterAccountVM() {
    }

    public RegisterAccountVM(@Pattern(regexp = "^[a-z0-9-]{3,20}$",
            message = "Tên đăng nhập không hợp lệ") String username, @Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,12})", message = "Mật khẩu không hợp lệ") String password, String confirmPassword, String birthDay, @NotEmpty(message = "Họ và tên không được trống") @Size(max = 15, message = "Họ và tên không dài quá 15 ký tự") String fullName) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthDay = birthDay;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

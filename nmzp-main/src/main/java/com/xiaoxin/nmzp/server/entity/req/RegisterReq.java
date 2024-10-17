package com.xiaoxin.nmzp.server.entity.req;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RegisterReq {
    @NotBlank(message = "用户名不能为空!")
    private String username;
    @NotBlank(message = "密码不能为空！")
    private String password;
    @NotBlank(message = "电话不能为空！")
    @Length(max = 11,min = 11,message = "电话只能为11位!")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$",message = "电话格式有误！")
    private String phonenumber;
    @NotBlank(message = "邮箱不能为空!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱格式有误！")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

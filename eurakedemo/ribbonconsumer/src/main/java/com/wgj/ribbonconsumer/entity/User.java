package com.wgj.ribbonconsumer.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2018-12-27 16:21:51
 */

public class User implements Serializable {
    private static final long serialVersionUID = 604488059542268319L;
    //自增id
    private Integer id;
    //email
    private String email;
    //密码
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

}
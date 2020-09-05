package com.poc.userrolemap.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
//Dummy
public class AC_Users {


    private Integer userId;
    private String username;
    private String password;
    private String loginId;
    private String mailId;
    private Date createdDate;
    private Date modifiedDate;

    public AC_Users() {
    }


    public AC_Users(Integer userId, String username, String password, String loginId, String mailId, Date createdDate, Date modifiedDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.loginId = loginId;
        this.mailId = mailId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

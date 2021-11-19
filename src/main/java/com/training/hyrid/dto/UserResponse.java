package com.training.hyrid.dto;

import lombok.Data;



import java.sql.Timestamp;

@Data
public class UserResponse {
    private Integer userId;
    private boolean statusUserAccount;
    private String email;
    private String password;
    private String loginToken;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private String role;

    public UserResponse(boolean statusUserAccount, String email, String password, String loginToken, Timestamp createdAt, Timestamp updateAt, String role) {
        this.statusUserAccount = statusUserAccount;
        this.email = email;
        this.password = password;
        this.loginToken = loginToken;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isStatusUserAccount() {
        return statusUserAccount;
    }

    public void setStatusUserAccount(boolean statusUserAccount) {
        this.statusUserAccount = statusUserAccount;
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

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }



}

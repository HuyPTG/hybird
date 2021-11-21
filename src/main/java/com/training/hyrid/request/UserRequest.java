package com.training.hyrid.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.hyrid.entities.Role;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Set;

@Data
public class UserRequest {
    private Integer userId;
    private boolean status;
    private String email;
    private String password;
    private String loginToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Set<String> role;

    public UserRequest(boolean status, String email, String password, String loginToken, Timestamp createdAt, Timestamp updatedAt, Set<String> role) {
        this.status = status;
        this.email = email;
        this.password = password;
        this.loginToken = loginToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    @JsonProperty("login_token")
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @JsonProperty("created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    @JsonProperty("updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}

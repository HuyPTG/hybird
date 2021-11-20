package com.training.hyrid.dto;

import java.sql.Timestamp;
import java.util.Set;

public class SignupRequest {

    private String email;
    private String password;
    private Set<String> role;
    private Timestamp createdAt;
    private Boolean status;

    public SignupRequest(String email, String password, Boolean status, Set<String> role, Timestamp createdAt) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
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

    public Set<String> getRole() {
        return this.role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
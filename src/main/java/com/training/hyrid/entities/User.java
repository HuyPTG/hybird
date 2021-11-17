package com.training.hyrid.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private Integer userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean statusUserAccount;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "login_token",  nullable = false, columnDefinition = "VARCHAR(255)")
    private String loginToken;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    public User() {

    }

    public User(Role role, boolean statusUserAccount, String email, String password, String loginToken, Timestamp createdAt, Timestamp updateAt) {
        this.role = role;
        this.statusUserAccount = statusUserAccount;
        this.email = email;
        this.password = password;
        this.loginToken = loginToken;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", role=" + role +
                ", statusUserAccount=" + statusUserAccount +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

package com.training.hyrid.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private Integer userId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean statusUserAccount;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "login_token",  nullable = false, columnDefinition = "VARCHAR(255)")
    private String loginToken;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    public User() {

    }

    public User(Set<Role> roles, boolean statusUserAccount, String email, String password, String loginToken, Timestamp createdAt, Timestamp updateAt) {
        this.roles = roles;
        this.statusUserAccount = statusUserAccount;
        this.email = email;
        this.password = password;
        this.loginToken = loginToken;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }


}

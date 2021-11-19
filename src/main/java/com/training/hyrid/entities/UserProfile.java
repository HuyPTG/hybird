package com.training.hyrid.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @Column(name = "id", columnDefinition = "INT(11)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position positionId;

 /*   private Branch*/

    @Column(name = "public_status", columnDefinition = "VARCHAR(255) DEFAULT TRUE")
    private String publicStatus;

    @Column(name = "birthday", columnDefinition = "DATETIME")
    private Date birthday;

    @Column(name = "full_name", columnDefinition = "VARCHAR(255)")
    private String fullName;

    @Column(name = "gender", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean gender;

    @Column(name = "branch", columnDefinition = "VARCHAR(255)")
    private String branch;

    @Column(name = "department", columnDefinition = "VARCHAR(255)")
    private String department;

    @Column(name = "number_phone", columnDefinition = "VARCHAR(11)")
    private String numberPhone;

    @Column(name = "facebook", columnDefinition = "VARCHAR(255)")
    private String facebook;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "url_img_avatar", columnDefinition = "VARCHAR(255)")
    private String imageAvatar;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    public UserProfile() {

    }


}

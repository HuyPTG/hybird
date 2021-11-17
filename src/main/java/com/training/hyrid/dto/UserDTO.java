package com.training.hyrid.dto;

import com.training.hyrid.entities.Role;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {
    private Integer userId;
    private boolean statusUserAccount;
    private String email;
    private String password;
    private String loginToken;
    private Timestamp createdAt;
    private Timestamp updateAt;
}

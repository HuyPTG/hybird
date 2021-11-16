package com.training.hyrid.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {
    private Integer Userid;
    private boolean statusUserAccount;
    private String email;
    private String password;
    private String loginToken;
    private Timestamp createdAt;
    private Timestamp updateAt;
}

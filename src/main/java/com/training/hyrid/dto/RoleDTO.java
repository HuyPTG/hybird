package com.training.hyrid.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoleDTO {
    private int RoleId;
    private String fullName;
    private String description;
    private Timestamp createdAt;
    private Timestamp updateAt;
}

package com.training.hyrid.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoleDTO {
    private Integer roleId;
    private String name;
    private String description;
    private Timestamp createdAt;
    private Timestamp updateAt;
}

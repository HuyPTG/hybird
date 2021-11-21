package com.training.hyrid.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Data
@Getter
@Setter
public class RoleResponse {
    private Integer roleId;
    private String name;
    private String description;
}

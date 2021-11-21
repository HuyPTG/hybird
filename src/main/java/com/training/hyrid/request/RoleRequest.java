package com.training.hyrid.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class RoleRequest {
    private Integer roleId;
    private String name;
    private String description;
}

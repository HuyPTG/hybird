package com.training.hyrid.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Setter
@Getter
public class PositionRequest {
    private Integer PositionId;
    private String positionName;
    private String description;
}

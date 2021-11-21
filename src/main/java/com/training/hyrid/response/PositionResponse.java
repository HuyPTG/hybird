package com.training.hyrid.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PositionResponse {
    private Integer PositionId;
    private String positionName;
    private String description;
}

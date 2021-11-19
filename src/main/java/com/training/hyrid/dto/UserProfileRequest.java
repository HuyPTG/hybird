package com.training.hyrid.dto;

import com.training.hyrid.entities.Branch;
import com.training.hyrid.entities.Department;
import com.training.hyrid.entities.Position;
import com.training.hyrid.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class UserProfileRequest {

    private String loginToke;
    private String fullName;
    private LocalDate birthday;
    private String publicStatus;
    private Boolean gender;
    private Integer branchId;
    private Integer departmentId;
    private Integer position;
    private String numberPhone;
    private String facebook;
    private String description;

}

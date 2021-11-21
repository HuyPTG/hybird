package com.training.hyrid.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class UserProfileRequest implements Serializable {

    private String loginToken;
    private String fullName;
    private LocalDate birthday;
    private boolean publicStatus;
    private Boolean gender;
    private Integer branchId;
    private Integer departmentId;
    private Integer positionId;
    private String numberPhone;
    private String facebook;
    private String description;

/*
    @JsonProperty("login_token")
    public String getLoginToken() {
        return loginToken;
    }

    @JsonProperty("login_token")
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @JsonProperty("public_status")
    public boolean isPublicStatus() {
        return publicStatus;
    }

    @JsonProperty("public_status")
    public void setPublicStatus(boolean publicStatus) {
        this.publicStatus = publicStatus;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @JsonProperty("branch_id")
    public Integer getBranchId() {
        return branchId;
    }

    @JsonProperty("branch_id")
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @JsonProperty("department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    @JsonProperty("department_id")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @JsonProperty("position_id")
    public Integer getPositionId() {
        return positionId;
    }

    @JsonProperty("position_id")
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @JsonProperty("number_phone")
    public String getNumberPhone() {
        return numberPhone;
    }

    @JsonProperty("number_phone")
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/
}

package com.training.hyrid.dto;

import com.training.hyrid.entities.Position;

import java.sql.Timestamp;

public class PositionDTO {
    private Integer PositionId;
    private String positionName;
    private String description;
    private Timestamp createdAt;
    private Timestamp updateAt;

    public PositionDTO(){

    }

    public PositionDTO(String positionName, String description, Timestamp createdAt, Timestamp updateAt) {
        this.positionName = positionName;
        this.description = description;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public PositionDTO(Position position){
        this.positionName = position.getPositionName();
        this.description = position.getDescription();
        this.createdAt = position.getCreatedAt();
        this.updateAt = position.getUpdateAt();
    }

    public Integer getPositionId() {
        return PositionId;
    }

    public void setPositionId(Integer positionId) {
        PositionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "PositionId=" + PositionId +
                ", positionName='" + positionName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

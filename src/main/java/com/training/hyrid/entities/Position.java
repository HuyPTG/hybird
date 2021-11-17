package com.training.hyrid.entities;


import com.training.hyrid.dto.PositionDTO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "position")
public class Position implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)")
	private Integer PositionId;

	@Column(name = "position_name",  nullable = false, columnDefinition = "VARCHAR(255)")
	private String positionName;

	@Column(name = "description", nullable = true, columnDefinition = "VARCHAR(255)")
	private String description;

	@Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updateAt;

	public Position() {

	}

	public Position(String positionName, String description, Timestamp createdAt, Timestamp updateAt) {
		super();
		this.positionName = positionName;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
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
		return "Position [PositionId=" + PositionId + ", positionName=" + positionName + ", description="
				+ description + ", createdAt=" + createdAt + ", updateAt=" + updateAt + "]";
	}

}

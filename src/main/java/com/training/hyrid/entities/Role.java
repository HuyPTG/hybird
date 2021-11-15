package com.training.hyrid.entities;

import java.sql.Timestamp;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)")
	private int RoleId;

	@Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
	private String fullName;

	@Column(name = "description", nullable = true, columnDefinition = "NVARCHAR(255)")
	private String description;

	@Column(name = "create_at", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updateAt;

	public Role() {

	}

	public Role(String fullName, String description, Timestamp createdAt, Timestamp updateAt) {
		super();
		this.fullName = fullName;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
		return "Role [RoleId=" + RoleId + ", fullName=" + fullName + ", description=" + description + ", createdAt="
				+ createdAt + ", updateAt=" + updateAt + "]";
	}

}

package com.training.hyrid.entities;

import java.sql.Timestamp;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)")
	private Integer roleId;


	@Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
	private String name;

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
		this.name = fullName;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Role{" +
				"roleId=" + roleId +
				", fullName='" + name + '\'' +
				", description='" + description + '\'' +
				", createdAt=" + createdAt +
				", updateAt=" + updateAt +
				'}';
	}
}
